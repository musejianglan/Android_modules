**一个data节点中可以配置多个<variable />标签**

> java.lang包里的类不需要导包

```
    <import type="java.util.List" />
    <import type="java.util.Map" />
```

<!--泛型的支持会在编译时期报红线，但是是可以直接运行的
       但是需要通过转义字符才行，如：<号用&lt表示;>号用&gt表示;-->
> **注意：android:text设置int类型的值一定要转化为String类型，否则系统会认为是资源文件id，就会出错**


> key要用``包裹，注意，这个不是单引号，而是Tab键上面的那个键的那个点
   android:text="@{mappp.get(`key`)}"

### 简单步骤

#### 1.builde.gradle添加DataBinding配置支持
```
    android {
         dataBinding {
            enabled = true
         }
    }

```

#### 2.创建一个简单的JavaBean对象
```
public class UserBean {
    private String name; //姓名
    private int age; //年龄

    public UserBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

```


#### 3.在Activity的布局文件activity_main.xml中使用DataBinding

> 1.使用layout作为根节点，包含了data节点和传统布局节点。data是view和Model的桥梁

> 2.TextView中没有使用id；而是在text属性中使用@{}，在大括号里引用userBean的属性对TextView进行赋值

```
<?xml version="1.0" encoding="utf-8"?>
<layout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    >

    <data>
        <variable
            name="user"
            type="com.musejianglan.databindingdemo.bean.UserBean"/>
    </data>
    <LinearLayout
        android:orientation="vertical"
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@{user.name}"/>

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@{String.valueOf(user.age)}"
            />


    </LinearLayout>



</layout>
```
#### 4.Activity中

> 使用DataBindingUtil.setContentView(this, R.layout.activity_main)代替setContentView(R.layout.activity_main);  
并获取ActivityMainBinding对象

> 通过ActivityMainBinding对象（binding.setUser(userBean) ）与与 variable 进行绑定

> ActivityMainBinding 是如何生成的呢？  
他是继承ViewDataBinding，这个类的生成是有规则的，  
它是根据对应的布局文件的名字生成的，比如：activity_main-->ActivityMainBinding  
fragment-->FragmentBinding即：第一个单词首字母大写，第二个单词首字母大写，
最后都会拼上Binding就是生成的Binding类。
  

```
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        ActivityMainBinding viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        UserBean userBean = new UserBean("暮色将蓝",20);
        viewDataBinding.setUser(userBean);
    }
}

```

---
### 绑定点击事件

#### 添加variable标签，引入OnClickListener变量
```
    <variable
        name="clicker"
        type="android.view.View.OnClickListener"
    />
    
    <Button
        android:id="@+id/btn_22"
        android:text="按钮222222"
        android:onClick="@{clicker}"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>
        
        
    viewDataBinding.setClicker(this);
    
    @Override
        public void onClick(View v) {
    
        }
```

### 多种数据类型

#### 基本数据类型


```
        <variable
            name="str"
            type="String"/>

        <variable
            name="nums"
            type="int"/>
            
            
         <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@{str}"
            />

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@{String.valueOf(nums)}"
            />
        
        
```

### BindingAdapter注解设置自定义属性 


```

public class DataBindingHelper {


    /**
     * 1.加载图片,无需手动调用此方法
     * 2.使用@BindingAdapter注解设置自定义属性的名称，imageUrl就是属性的名称，
     * 当ImageView中使用imageUrl属性时，会自动调用loadImage方法
     * 必须是静态的方法
     * @param imageView 控件
     * @param url 属性值
     */
    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView,String url){

        //Glid
        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);

    }
    
    注意：方法的第一个参数必须是view
    Error:(16, 17) 错误: @BindingAdapter loadImage(java.lang.String,android.widget.ImageView) 
    is applied to a method that has two parameters, the first must be a View type
    
    <variable
                name="imgUrl"
                type="String"/>
                
    <ImageView
                android:layout_width="match_parent"
                android:layout_height="200dp"
                app:imageUrl="@{imgUrl}"
                />
                
     viewDataBinding.setImgUrl("http://7xi8d6.com1.z0.glb.clouddn.com/20180129074038_O3ydq4_Screenshot.jpeg");
}
```

### View with ID

> 布局中每一个带有 ID 的 View，都会生成一个 public final 字段。binding 过程会做一个简单的赋值，在 binding 类中保存对应 ID 的 View。这种机制相比调用 

```
 <TextView
            android:id="@+id/text_age"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@{String.valueOf(user.age)}"
            />
 
 <Button
             android:id="@+id/btn_22"
             android:text="RecyclerView"
             android:onClick="@{clicker}"
             android:layout_width="wrap_content"
             android:layout_height="wrap_content"/>
             
             viewDataBinding.btn1.setText("绑定多种数据类型");
             viewDataBinding.textAge.setText("更改age:"+2222);

 生成规则：去掉下划线后首字母大写
```

### 动态更新

#### BaseObservable

> 步骤
1. bean继承BaseObservable
2. 用 @Bindable 标记过 getter 方法
3. 通过调用notifyPropertyChanged(BR.属性名称)来通知系统 
4. 通过set方法更新属性
```
public class UserBean extends BaseObservable {

    private String name;
    private int age;

    public UserBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }
}

userBean.setAge((int) Math.random());
userBean.setName(new Date().getTime()+"=====>>>>");
```
   


#### ObservableFields

---

#### 为什么配置了 dataBinding{enabled = true}之后就可以使用dataBinding方式进行开发了？

> Android Studio中是依靠gradle来管理项目的，在创建一个项目时，从开始创建一直到创建完毕，整个过程是需要执行很多个gradle task的，
这些task有很多是系统预先帮我们定义好的，比如build task，clean task等，DataBinding相关的task也是系统预先帮我们定义好的。
但是默认情况下，DataBinding相关的task在task列表中是没有的，因为我们没有开启dataBinding,
但是一旦我们通过 dataBinding{enabled = true}的方式开启DataBinding之后，DataBinding相关的task就会出现在task列表中，
每当我们执行编译之类的操作时，就会执行这些dataBinding Task, 这些task的作用就是检查并生成相关dataBinding代码，
比如dataBindingExportBuildInfoDebug这个task就是用来导出debug模式下的build信息的。

#### ActivityMainBinding这个类从哪来的？

> 通过第一个问题的解释，我们也就知道了ActivityMainBinding这个类其实是系统帮我们自动生成的。
  但是如果你在实际编写代码的过程中，你会发现并没有执行编译、运行之类等操作，ActivityMainBinding这个类就直接能用了，竟然还有这种操作？
  其实是Android Studio 这个IDE自动帮我们做了这一步，在默认情况下，
  系统会使用Android Studio为我们自动生成databinding相关的代码，但是这种方式生成的代码不能调试，
  如果你想通过点击ActivityMainBinding跳转到它的源码中，你会发现并不能如你所愿，而是会跳转到对应的布局文件中。那么如果我们确实要
  查看ActivityMainBinding的源码并且还想调试，
  我们就需要通过另外一种方式：手动编译代码。这两种方式可以通过Android Studio的设置面板修改。


#### DataBinding与ButterKnife的区别
> ButterKnife很多人都用过，在以前的findViewById的时代，我们厌烦了写这些重复的代码，当有了ButterKnife之后，我们采用注解的方式来查找控件和注册监听，
配合ButterKnife的插件，大大提升了我们的开发效率，一度成为开发神器，但是有了DataBinding之后，你会发现使用ButterKnife开发还是不够简洁：
比如你需要给很多TextView setText()要获取editText的内容前必须要获取editText对象，给view设置监听前也必须要获取这个view对象等等。
但是使用了DataBinding之后，这些冗余的代码统统都可以得到简化，从而真正的只需要专注于你的业务逻辑的处理即可。



