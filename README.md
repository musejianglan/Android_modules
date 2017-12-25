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
    //Glide3 使用Glide4有点问题，暂时使用3
    implementation 'com.github.bumptech.glide:glide:3.7.0'

    //事件总线
    //greenrobot eventbus
    implementation 'org.greenrobot:eventbus:3.1.1'
    //square otto
    implementation 'com.squareup:otto:1.3.8'

}

```