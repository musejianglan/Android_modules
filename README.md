# Android_modules


```
app_build.gradle
dependencies {
    //rxjava2 Android
    implementation 'io.reactivex.rxjava2:rxandroid:2.0.1'
    implementation 'io.reactivex.rxjava2:rxjava:2.1.7'

    // RxJava1 Android 支持
    // compile 'io.reactivex:rxjava:1.3.0'
    // compile 'io.reactivex:rxandroid:1.2.1'

    // Retrofit2 网络支持
    implementation 'com.squareup.retrofit2:retrofit:2.3.0'
    // Gson 适配器
    implementation 'com.squareup.retrofit2:converter-gson:2.1.0'
    //retrofit rx适配器
    implementation 'com.squareup.retrofit2:adapter-rxjava2:2.3.0'
    //okhttp logging
    implementation 'com.squareup.okhttp3:logging-interceptor:3.8.0'

    //glide
    implementation 'com.github.bumptech.glide:glide:3.7.0'
    //glide transformation
    implementation 'jp.wasabeef:glide-transformations:2.0.2'
    implementation 'jp.co.cyberagent.android.gpuimage:gpuimage-library:1.4.1'

    //picasso
    implementation 'com.squareup.picasso:picasso:2.5.2'
    //picasso transformat
    implementation 'jp.wasabeef:picasso-transformations:2.1.2'
    // If you want to use the GPU Filters
    implementation 'jp.co.cyberagent.android.gpuimage:gpuimage-library:1.4.1'

    //fresco
    implementation 'com.facebook.fresco:fresco:1.7.1'

    //事件总线
    //greenrobot eventbus
    implementation 'org.greenrobot:eventbus:3.1.1'
    //square otto
    implementation 'com.squareup:otto:1.3.8'

    //butterknife
    compile 'com.jakewharton:butterknife:8.8.1'
    annotationProcessor 'com.jakewharton:butterknife-compiler:8.8.1'

    //gson
    compile 'com.google.code.gson:gson:2.8.0'

}

```
## Android设计模式[mvpdemo](https://github.com/musejianglan/Android_modules/tree/master/mvpdemo)
* mvp

## 依赖注入[IOCandroiddemo](https://github.com/musejianglan/Android_modules/tree/master/iocandroiddemo)
* ButterKnife
* Dagger2未完成

## 图片加载及处理[picapp](https://github.com/musejianglan/Android_modules/tree/master/picapp)
* Glide
* Picasso
* Fresco

## 响应式编程[rxjavademo](https://github.com/musejianglan/Android_modules/tree/master/rxjavademo)
* RxJava
* RxAndroid
* RxJavaJoins未完成
* RxBinding未完成
* RxBus未完成
* RxPermissions未完成
* RxLifecycle未完成
* RxBinding未完成

## 事件总线 [eventbusdemo](https://github.com/musejianglan/Android_modules/tree/master/eventbusdemo)
* EventBus
* Otto

## 网络请求[rxjavademo](https://github.com/musejianglan/Android_modules/tree/master/rxjavademo)
* retrofit
* okhttp

## log框架

## 缓存
* DiskLruCache未完成


## 解析[rxjavademo](https://github.com/musejianglan/Android_modules/tree/master/rxjavademo)
* Gson

## 数据库
* Greendao未完成
* ObjectBox未完成

## 内存[picapp](https://github.com/musejianglan/Android_modules/tree/master/picapp)
* leakcanary

## 图表
## 后台处理
## 测试框架
## 调试框架
## 性能优化

----
## 优秀库

### Shortbread
Android 7.0允许用户长按桌面图标弹出快捷菜单。该库可以帮助开发者快速开发app shortcuts。
[Shortbread](https://github.com/MatthiasRobbers/shortbread)

[shortcuts动态添加]()

### Lottie
这是一个动画库。通过Adobe After Effects做出动画效果，然后通过Bodymovin(AE的插件）导出JSON数据，然后通过该库生成原生动画效果。
在Google Play Store上可以下载demo。
该项目在Github上已经由超过8000个star。
猴赛雷~~ ***Airbnb***公司出品。  
[Lottie](https://github.com/airbnb/lottie-android)
### Toasty
自定义toast库
[Toasty](https://github.com/GrenderG/Toasty)
### StyleableToast
这也是一个Toast增强库。

[StyleableToast](https://github.com/Muddz/StyleableToast)

### Store
Store是一个异步数据加载和缓存数据的库。
[Store](https://github.com/NYTimes/Store)

### PreviewSeekBar
[PreviewSeekBar](https://github.com/rubensousa/PreviewSeekBar)


### Chuck
如果你使用OkHttp作为网络请求库，那么这个Chuck库可以帮助你拦截留存所有的HTTP请求和相应信息。同时也提供UI来显示拦截的信息  
[Chuck](https://github.com/jgilfelt/chuck)

### CoordinatorTabLayout
该库可以帮你快速实现TabLayout和CoordinatorLayout的组合效果。  
[CoordinatorTabLayout](https://github.com/hugeterry/CoordinatorTabLayout)


### boxing
boxing是一个多媒体选择器库。

可以选择一张或者多张图片，提供预览和裁剪功能。

同样支持gif图，选择视频和图像压缩功能。  
[boxing](https://github.com/Bilibili/boxing)

### excelPanel
提供一个二维的RecyclerView控件。  
[excelPanel](https://github.com/zhouchaoyuan/excelPanel)

### HorizontalCalendar
[HorizontalCalendar](https://github.com/Mulham-Raee/HorizontalCalendar)

### CameraFragment

[CameraFragment](https://github.com/florent37/CameraFragment)
### AwesomeBar
该控件时Topbar的一个扩展，类似于Actionbar或者Toolbar。可结合DrawerLayout使用。  
[AwesomeBar](https://github.com/florent37/AwesomeBar)

### ArcNavigationView
这是一个有弯曲边缘效果的NavigationView控件。  
[ArcNavigationView](https://github.com/rom4ek/ArcNavigationView)

### ShimmerRecyclerView
这个一个自定义的RecyclerView，在加载item的时候可以“bulingbuling”的闪动。可以通过内置的adapter控制效果。
[ShimmerRecyclerView](https://github.com/sharish/ShimmerRecyclerView)

### Android-SwitchIcon
这是个自定义的switch控件。扩展自AppCompatImageView，允许使用vector和image。  
[Android-SwitchIcon](https://github.com/zagum/Android-SwitchIcon)

### CounterFab
该库针对FloatingActionButton的扩展，可以显示角标。  
[CounterFab](https://github.com/andremion/CounterFab)

### FlowLayout
流式标签布局  
[FlowLayout](https://github.com/nex3z/FlowLayout)






