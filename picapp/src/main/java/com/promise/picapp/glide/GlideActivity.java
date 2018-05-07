package com.promise.picapp.glide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Priority;
import com.promise.picapp.R;

public class GlideActivity extends AppCompatActivity {

    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    private ImageView image5;
    private ImageView image6;
    private ImageView image7;
    private ImageView image8;
    private ImageView image9;
    private ImageView image10;
    private ImageView image11;
    private ImageView image12;
    private ImageView image13;
    private ImageView image14;
    private ImageView image15;
    private ImageView image16;
    private ImageView image17;
    private ImageView image18;
    private ImageView image19;
    private ImageView image20;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);



        GlideApp.with(this)
                .load("https://ws1.sinaimg.cn/large/610dc034ly1fik2q1k3noj20u00u07wh.jpg")
                .skipMemoryCache(true)
//                .crossFade()//图片平滑加载处理，没有参数默认300毫秒
                .override(1000,5000)
                .into(image1);
        GlideApp.with(this)
                .load("https://ws1.sinaimg.cn/large/610dc034ly1fiiiyfcjdoj20u00u0ju0.jpg")
                .skipMemoryCache(true)
                .dontAnimate()
                .into(image2);
        //imageview 宽高全为match_parent，无法显示

        //.crossFade()//图片平滑加载处理，没有参数默认300毫秒
        //.dontAnimate()不使用crossFade动画
        //.override(1000,5000)设置图片大小
        //CenterCrop()会缩放图片让图片充满整个ImageView的边框，然后裁掉超出的部分。ImageVIew会被完全填充满，但是图片可能不能完全显示出。
        //fitCenter()会缩放图片让两边都相等或小于ImageView的所需求的边框。图片会被完整显示，可能不能完全填充整个ImageView。
        //
        //
        //
        //
        //

        //占位图
        GlideApp.with(this)
                .load("https://ws1.sinaimg.cn/large/610dc034ly1fibksd2mbmj20u011iacx.jpg")
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round)

                .into(image3);


        String gifUrl = "http://i.kinja-img.com/gawker-media/image/upload/s--B7tUiM5l--/gf2r69yorbdesguga10i.gif";
        String notgifUrl = "http://7xi8d6.com1.z0.glb.clouddn.com/20171211082435_CCblJd_Screenshot.jpeg";
        GlideApp.with(GlideActivity.this)
                .load(gifUrl)

//                .asBitmap()

                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round)
                .priority(Priority.LOW)

                .into(image4);


        /**
         *
         * .asGif()：检查图片是否是gif图片，如果不是现实error占位图或者不加载
         * .asBitmap()如果图片是gif图片，显示第一帧
         * .asGif(),.asBitmap()必须在.placeholder(R.mipmap.ic_launcher_round)和.error(R.mipmap.ic_launcher_round)前调用
         *
         * .asGif(),.asBitmap()这俩互斥，不能同时调用
         */


        //缓存
        /**
         * \默认使用内存和磁盘缓存来避免不必要的网络请求
         *
         * .skipMemoryCache( true )跳过内存缓存
         *
         * .diskCacheStrategy( DiskCacheStrategy.NONE )跳过硬盘缓存
         *
         * DiskCacheStrategy.NONE 啥也不缓存
         * DiskCacheStrategy.SOURCE 只缓存全尺寸图. 上面例子里的1000x1000像素的图片
         * DiskCacheStrategy.RESULT 只缓存最终降低分辨后用到的图片
         * DiskCacheStrategy.ALL 缓存所有类型的图片 (默认行为)
         *
         */

        /**
         * .priority(Priority.NORMAL)
         * 图片加载优先级
         * Priority.NORMAL/HIGH/IMMEDIATE/LOW
         * Glide会将它们作为一个指导来最优化处理请求。但并不意味着所有的图片都能够按请求的顺序加载。
         */



        //
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        GlideApp.with(this)
                .load("https://ws1.sinaimg.cn/large/610dc034ly1fibksd2mbmj20u011iacx.jpg")
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round)
                .into(image5);

        //简单缩略图
        GlideApp.with(this)
                .load("https://ws1.sinaimg.cn/large/610dc034ly1fibksd2mbmj20u011iacx.jpg")
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round)
                .thumbnail(0.1f)
                .into(image6);

//        DrawableRequestBuilder<String> thumbnailRequest = Glide
//                .with( this )
//                .load( "http://7xi8d6.com1.z0.glb.clouddn.com/20171114101305_NIAzCK_rakukoo_14_11_2017_10_12_58_703.jpeg" );//单独的请求缩略图

        GlideApp.with(this)
                .load("http://img.zcool.cn/community/01c0a658a1aa25a801219c778e4c6e.gif")
//                .thumbnail(thumbnailRequest)
                .into(image7);
        /**
         * .thumbnail(0.001f)
         * 缩略图
         */



        //
        image8 = findViewById(R.id.image8);

//        SimpleTarget<Bitmap> simpleTarget = new SimpleTarget<Bitmap>() {
//            @Override
//            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
//                image8.setImageBitmap( resource );
//            }
//        };
//        GlideApp.with(this)
//                .load("http://7xi8d6.com1.z0.glb.clouddn.com/20171113084220_LuJgqv_sakura.gun_13_11_2017_8_42_12_311.jpeg")
//                .asBitmap()
//                .into(simpleTarget);

//        GlideApp.with(this)
//                .load("http://7xi8d6.com1.z0.glb.clouddn.com/20171113084220_LuJgqv_sakura.gun_13_11_2017_8_42_12_311.jpeg")
//                .asBitmap()
//                .into(new Target<Bitmap>() {
//                    @Override
//                    public void onLoadStarted(Drawable placeholder) {
//                        log("onLoadStarted");
//                    }
//
//                    @Override
//                    public void onLoadFailed(Exception e, Drawable errorDrawable) {
//
//                        log(e.getMessage());
//                    }
//
//                    @Override
//                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
//
//                        log("resourceready");
//                    }
//
//                    @Override
//                    public void onLoadCleared(Drawable placeholder) {
//                        log("cleard");
//                    }
//
//                    @Override
//                    public void getSize(SizeReadyCallback cb) {
//                        log(""+cb.toString());
//                    }
//
//                    @Override
//                    public void setRequest(Request request) {
//
//                    }
//
//                    @Override
//                    public Request getRequest() {
//                        return null;
//                    }
//
//                    @Override
//                    public void onStart() {
//                        log("sarty");
//                    }
//
//                    @Override
//                    public void onStop() {
//                        log("stop");
//                    }
//
//                    @Override
//                    public void onDestroy() {
//                        log("destroy");
//                    }
//                });


        //NotificationTarget notificationTarget = new NotificationTarget()



        //变换
        image9 = findViewById(R.id.image9);
        image10 = findViewById(R.id.image10);
        image11 = findViewById(R.id.image11);
        image12 = findViewById(R.id.image12);
        image13 = findViewById(R.id.image13);
        image14 = findViewById(R.id.image14);
        image15 = findViewById(R.id.image15);
        image16 = findViewById(R.id.image16);
        image17 = findViewById(R.id.image17);
        String url9 = "http://ww4.sinaimg.cn/large/610dc034gw1fa0ppsw0a7j20u00u0thp.jpg";
        String url10 = "http://ww2.sinaimg.cn/large/610dc034gw1f9zjk8iaz2j20u011hgsc.jpg";
        String url11 = "http://ww4.sinaimg.cn/large/610dc034jw1f9mp3xhjdhj20u00u0ta9.jpg";
        String url12 = "http://ww2.sinaimg.cn/large/610dc034gw1f9lmfwy2nij20u00u076w.jpg";
        String url13 = "http://ww2.sinaimg.cn/large/610dc034gw1f9kjnm8uo1j20u00u0q5q.jpg";
        String url14 = "http://ww2.sinaimg.cn/large/610dc034jw1f9j7nvnwjdj20u00k0jsl.jpg";
        String url15 = "http://ww2.sinaimg.cn/large/610dc034jw1f9b46kpoeoj20ku0kuwhc.jpg";
        String url16 = "http://ww2.sinaimg.cn/large/610dc034jw1f5aqgzu2oej20rt15owo7.jpg";
        String url17 = "http://ww4.sinaimg.cn/large/610dc034gw1f96kp6faayj20u00jywg9.jpg";



//        Glide.with(this)
//                .load(url9)
//                .bitmapTransform(new CropCircleTransformation(GlideActivity.this))
//                .into(image9);//圆形裁剪
//
//        Glide.with(this)
//                .load(url10)
//                .bitmapTransform(new CropSquareTransformation(GlideActivity.this))
//                .into(image10);//正方形裁剪
//
//        Glide.with(this)
//                .load(url11)
//                .bitmapTransform(new RoundedCornersTransformation(GlideActivity.this,50,50))
//                .into(image11);//圆角裁剪
//
//        Glide.with(this)
//                .load(url12)
//                .bitmapTransform(new CropTransformation(GlideActivity.this,200,200))
//                .into(image12);//自定义大小裁剪
//
//        Glide.with(this)
//                .load(url13)
//                .bitmapTransform(new ColorFilterTransformation(GlideActivity.this, Color.parseColor("#66ff0000")))
//                .into(image13);//加滤镜（蒙层颜色值）
//        Glide.with(this)
//                .load(url14)
//                .bitmapTransform(new GrayscaleTransformation(GlideActivity.this))
//                .into(image14);//灰度级转换（变成黑白照）
//
//        Glide.with(this)
//                .load(url15)
//                .bitmapTransform(new BlurTransformation(GlideActivity.this))
//                .into(image15);//模糊 默认模糊度25
//        Glide.with(this)
//                .load(url16)
//                .bitmapTransform(new BlurTransformation(GlideActivity.this,15))
//                .into(image16);//模糊
//        //使用构造方法 BlurTransformation(Context context, int radius, int sampling)
//        // radius : 离散半径/模糊度（单参构造器 - 默认25）
//        // sampling : 取样（单参构造器 - 默认1） 如果取2，横向、纵向都会每两个像素点取一个像素点(即:图片宽高变为原来一半)
//
//
//        Glide.with(this)
//                .load(url17)
//                .bitmapTransform(new MaskTransformation(GlideActivity.this,R.mipmap.ic_launcher_round))
//                .into(image17);//遮罩掩饰（视图叠加处理）



        /**
         * Crop：CropTransformation, CropCircleTransformation, CropSquareTransformation, RoundedCornersTransformation
         Color: ColorFilterTransformation, GrayscaleTransformation
         Blur: BlurTransformation
         Mask:MaskTransformation
         */

        //GPU TODO
        /**
         * ToonFilterTransformation, SepiaFilterTransformation, ContrastFilterTransformation
         InvertFilterTransformation, PixelationFilterTransformation, SketchFilterTransformation
         SwirlFilterTransformation, BrightnessFilterTransformation, KuwaharaFilterTransformation VignetteFilterTransformation
         */

    }



    public void log(String msg){

        Log.d("promise",msg);
    }


}


