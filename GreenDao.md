### 1.project builde.gradle 添加plugin

classpath 'org.greenrobot:greendao-gradle-plugin:3.2.2' // add plugin

### 2. app builder.gradle 添加plugin和dependencies

apply plugin: 'org.greenrobot.greendao' // apply plugin

implementation 'org.greenrobot:greendao:3.2.2'

### 3. app builder.gradle 添加greendao版本控制及相关参数
```
greendao {
    schemaVersion 1 //数据库版本
    daoPackage 'com.promise.pdfreader.greendao.gen' // build之后自动生成dao目录
    targetGenDir 'src/main/java'
}
```

### 4.Entities and Annotations 实体类添加注解，会根据注解自动生成表

```
@Entity
public class PdfInfoEntity {

    @Id(autoincrement = true)
    private Long id;
    @NotNull
    private String fileName;
    @NotNull
    @Unique
    private String path;
    @NotNull
    private int currentPage;
    private int pageCount;
    private Date updateTime;
    private String cover;

    @Transient
    private boolean isAdded = false;
}


@Entity 　表明这个实体类会在数据库中生成一个与之相对应的表。
     @nameInDb 在数据库中的名字，如不写则为实体中类名
     @indexes 索引
     @createInDb 是否创建表，默认为true,false时不创建
     @schema 指定架构名称为实体
     @active 无论是更新生成都刷新


@Id 　对应数据表中的 Id 字段，有了解数据库的话，是一条数据的唯一标识。
@Id(autoincrement = true) id自动加
@Property(nameInDb = “STUDENTNUM”) 　表名这个属性对应数据表中的 STUDENTNUM 字段。
@Property 　可以自定义字段名，注意外键不能使用该属性
@NotNull 　该属性值不能为空
@Transient 　该属性不会被存入数据库中
@Unique 　表名该属性在数据库中只能有唯一值

@ToMany 一对多
@OrderBy 排序
@ToOne 一对一 关系表

```

### 4.builde

然后自建DaoManager类，用于统一管理
```
public class GreenDaoManager {

    DaoMaster.OpenHelper helper;
    private static final String DB_NAME = "pdf_db";//数据库名字
    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;

    private static final GreenDaoManager ourInstance = new GreenDaoManager();

    public static GreenDaoManager getInstance() {
        return ourInstance;
    }

    private GreenDaoManager() {
        helper = new DaoMaster.DevOpenHelper(App.getInstance(), DB_NAME);
        db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession() {

        return daoSession;
    }
}

```

### 5. 获取对应实体类的Dao，并实现增删改查

PdfInfoEntityDao pdfDao = GreenDaoManager.getInstance().getDaoSession().getPdfInfoEntityDao();

#### 增
#### 删
#### 改
#### 查


### 数据库升级

在数据库升级的地方调用
```
MigrationHelper.getInstance().migrate(db,
                UserDao.class,
                ItemDao.class);

```

```
/**国外大神做的升级类
 * Created by pokawa on 18/05/15.
 */
public class MigrationHelper {

    private static final String CONVERSION_CLASS_NOT_FOUND_EXCEPTION = "MIGRATION HELPER - CLASS DOESN'T MATCH WITH THE CURRENT PARAMETERS";
    private static MigrationHelper instance;

    public static MigrationHelper getInstance() {
        if(instance == null) {
            instance = new MigrationHelper();
        }
        return instance;
    }

    public void migrate(SQLiteDatabase db, Class<? extends AbstractDao<?, ?>>... daoClasses) {
        generateTempTables(db, daoClasses);
        DaoMaster.dropAllTables(db, true);
        DaoMaster.createAllTables(db, false);
        restoreData(db, daoClasses);
    }

    private void generateTempTables(SQLiteDatabase db, Class<? extends AbstractDao<?, ?>>... daoClasses) {
        for(int i = 0; i < daoClasses.length; i++) {
            DaoConfig daoConfig = new DaoConfig(db, daoClasses[i]);

            String divider = "";
            String tableName = daoConfig.tablename;
            String tempTableName = daoConfig.tablename.concat("_TEMP");
            ArrayList<String> properties = new ArrayList<>();

            StringBuilder createTableStringBuilder = new StringBuilder();

            createTableStringBuilder.append("CREATE TABLE ").append(tempTableName).append(" (");

            for(int j = 0; j < daoConfig.properties.length; j++) {
                String columnName = daoConfig.properties[j].columnName;

                if(getColumns(db, tableName).contains(columnName)) {
                    properties.add(columnName);

                    String type = null;

                    try {
                        type = getTypeByClass(daoConfig.properties[j].type);
                    } catch (Exception exception) {
                        Crashlytics.logException(exception);
                    }

                    createTableStringBuilder.append(divider).append(columnName).append(" ").append(type);

                    if(daoConfig.properties[j].primaryKey) {
                        createTableStringBuilder.append(" PRIMARY KEY");
                    }

                    divider = ",";
                }
            }
            createTableStringBuilder.append(");");

            db.execSQL(createTableStringBuilder.toString());

            StringBuilder insertTableStringBuilder = new StringBuilder();

            insertTableStringBuilder.append("INSERT INTO ").append(tempTableName).append(" (");
            insertTableStringBuilder.append(TextUtils.join(",", properties));
            insertTableStringBuilder.append(") SELECT ");
            insertTableStringBuilder.append(TextUtils.join(",", properties));
            insertTableStringBuilder.append(" FROM ").append(tableName).append(";");

            db.execSQL(insertTableStringBuilder.toString());
        }
    }

    private void restoreData(SQLiteDatabase db, Class<? extends AbstractDao<?, ?>>... daoClasses) {
        for(int i = 0; i < daoClasses.length; i++) {
            DaoConfig daoConfig = new DaoConfig(db, daoClasses[i]);

            String tableName = daoConfig.tablename;
            String tempTableName = daoConfig.tablename.concat("_TEMP");
            ArrayList<String> properties = new ArrayList();

            for (int j = 0; j < daoConfig.properties.length; j++) {
                String columnName = daoConfig.properties[j].columnName;

                if(getColumns(db, tempTableName).contains(columnName)) {
                    properties.add(columnName);
                }
            }

            StringBuilder insertTableStringBuilder = new StringBuilder();

            insertTableStringBuilder.append("INSERT INTO ").append(tableName).append(" (");
            insertTableStringBuilder.append(TextUtils.join(",", properties));
            insertTableStringBuilder.append(") SELECT ");
            insertTableStringBuilder.append(TextUtils.join(",", properties));
            insertTableStringBuilder.append(" FROM ").append(tempTableName).append(";");

            StringBuilder dropTableStringBuilder = new StringBuilder();

            dropTableStringBuilder.append("DROP TABLE ").append(tempTableName);

            db.execSQL(insertTableStringBuilder.toString());
            db.execSQL(dropTableStringBuilder.toString());
        }
    }

    private String getTypeByClass(Class<?> type) throws Exception {
        if(type.equals(String.class)) {
            return "TEXT";
        }
        if(type.equals(Long.class) || type.equals(Integer.class) || type.equals(long.class)) {
            return "INTEGER";
        }
        if(type.equals(Boolean.class)) {
            return "BOOLEAN";
        }

        Exception exception = new Exception(CONVERSION_CLASS_NOT_FOUND_EXCEPTION.concat(" - Class: ").concat(type.toString()));
        Crashlytics.logException(exception);
        throw exception;
    }

    private static List<String> getColumns(SQLiteDatabase db, String tableName) {
        List<String> columns = new ArrayList<>();
        Cursor cursor = null;
        try {
            cursor = db.rawQuery("SELECT * FROM " + tableName + " limit 1", null);
            if (cursor != null) {
                columns = new ArrayList<>(Arrays.asList(cursor.getColumnNames()));
            }
        } catch (Exception e) {
            Log.v(tableName, e.getMessage(), e);
            e.printStackTrace();
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return columns;
    }
}

```