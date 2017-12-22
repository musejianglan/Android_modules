package com.promise.picapp.picasso;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.promise.picapp.R;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.BlurTransformation;
import jp.wasabeef.picasso.transformations.ColorFilterTransformation;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;
import jp.wasabeef.picasso.transformations.CropSquareTransformation;
import jp.wasabeef.picasso.transformations.CropTransformation;
import jp.wasabeef.picasso.transformations.GrayscaleTransformation;
import jp.wasabeef.picasso.transformations.MaskTransformation;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class PicassoActivity extends AppCompatActivity {

    private ImageView img_picasso_1;
    private ImageView img_picasso_2;
    private ImageView img_picasso_3;
    private ImageView img_picasso_4;
    private ImageView img_picasso_5;
    private ImageView img_picasso_6;
    private ImageView img_picasso_7;
    private ImageView img_picasso_8;
    private ImageView img_picasso_9;
    private ImageView img_picasso_10;
    private ImageView img_picasso_11;
    private ImageView img_picasso_12;
    private ImageView img_picasso_13;
    private ImageView img_picasso_14;
    private ImageView img_picasso_15;
    private ImageView img_picasso_16;
    private ImageView img_picasso_17;
    private ImageView img_picasso_18;
    private ImageView img_picasso_19;
    private ImageView img_picasso_20;
    private ImageView img_picasso_21;
    private ImageView img_picasso_22;
    private ImageView img_picasso_23;
    private ImageView img_picasso_24;
    private ImageView img_picasso_25;
    private ImageView img_picasso_26;
    private ImageView img_picasso_27;
    private ImageView img_picasso_28;
    private ImageView img_picasso_29;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);

        img_picasso_1 = findViewById(R.id.img_picasso_1);
        img_picasso_2 = findViewById(R.id.img_picasso_2);

        Picasso.with(this)
                .load("http://ww2.sinaimg.cn/large/7a8aed7bjw1f0cw7swd9tj20hy0qogoo.jpg")
                .into(img_picasso_1);
        Picasso.with(this)
                .load("http://ww2.sinaimg.cn/large/7a8aed7bjw1f0buzmnacoj20f00liwi2.jpg")
                .into(img_picasso_2);

        img_picasso_3 = findViewById(R.id.img_picasso_3);
        Picasso.with(this)
                .load("http://ww1.sinaimg.cn/large/7a8aed7bjw1f0bifjrh39j20v018gwtj.jpg")
                .into(img_picasso_3);
        img_picasso_4 = findViewById(R.id.img_picasso_4);

        //
        Picasso.with(this)
                .load("http://ww4.sinaimg.cn/large/7a8aed7bjw1f082c0b6zyj20f00f0gnr.jpg")//方形图片资源
                //占位图
                .placeholder(R.mipmap.ic_launcher_round)
                //.noPlaceholder()
                .error(R.mipmap.ic_launcher)

                //.resize(200,300)
                //.onlyScaleDown()

                //.centerInside()
                .noFade()
                .fit()
                .centerCrop()
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(img_picasso_4);
        /**
         * .onlyScaleDown()----.resize(200,300) 当原始图片尺寸大约裁剪尺寸是才起作用,必须在resize之后调用
         *
         *
         * .centerInside()和.centerCrop()需要跟.resize(200,300)搭配使用
         * centerCrop()居中裁剪
         * centerInside：将图片展示完全，可以用centerInside，但是如果图片尺寸小于View尺寸的话，是不能充满View边界的
         *
         * .fit():自动测量view的大小然后按需裁剪（fit只对Imageview有效，并且imageview的宽高不能是wrap）(最好搭配centerCrop 使用，.centerCrop()必须在fit之后)
         *
         * .placeholder(R.mipmap.ic_launcher_round)和.noPlaceholder()不能同时出现
         *
         * noFade()取消加载过度动画
         *
         * 缓存
         *  .memoryPolicy(参数)
         *  MemoryPolicy.NO_CACHE：表示处理请求的时候跳过检查内存缓存
         *  NO_STORE: ** 表示请求成功之后，不将最终的结果存到内存
         *
         *  .networkPolicy(参数)
         *  NO_CACHE: 表示处理请求的时候跳过处理磁盘缓存
         *   NO_STORE:** 表示请求成功后，不将结果缓存到Disk,但是这个只对OkHttp有效。
         *   OFFLINE: 这个就跟 上面两个不一样了，如果networkPolicy方法用的是这个参数，那么Picasso会强制这次请求从缓存中获取结果，不会发起网络请求，不管缓存中能否获取到结果。
         */
        img_picasso_5 = findViewById(R.id.img_picasso_5);
        Picasso.with(this)
                .load("http://ww1.sinaimg.cn/large/7a8aed7bjw1f05pbp0p0yj20go0mu77b.jpg")
                .fit()
                .rotate(50)
                .into(img_picasso_5);

        //--------------------------------------------------

        /**
         * Crop:CropTransformation, CropCircleTransformation, CropSquareTransformation, RoundedCornersTransformation
         */
        img_picasso_6 = findViewById(R.id.img_picasso_6);
        img_picasso_7 = findViewById(R.id.img_picasso_7);
        img_picasso_8 = findViewById(R.id.img_picasso_8);
        img_picasso_9 = findViewById(R.id.img_picasso_9);

        Picasso.with(this)
                .load("http://ww1.sinaimg.cn/large/7a8aed7bjw1f04m5ngwwaj20dw0kmwgn.jpg")
                .transform(new CropTransformation(50,50,50,50))
                .into(img_picasso_6);
        Picasso.with(this)
                .load("http://ww1.sinaimg.cn/large/7a8aed7bjw1f03emebr4jj20ez0qoadk.jpg")
                .transform(new CropCircleTransformation())
                .into(img_picasso_7);
        Picasso.with(this)
                .load("http://ww1.sinaimg.cn/large/7a8aed7bjw1ezzaw04857j20p00gp40w.jpg")
                .transform(new CropSquareTransformation())
                .into(img_picasso_8);
        Picasso.with(this)
                .load("http://ww1.sinaimg.cn/large/7a8aed7bjw1ezysj9ytj5j20f00m8wh0.jpg")
                .transform(new RoundedCornersTransformation(50,50))
                .into(img_picasso_9);
        /**
         * Color:ColorFilterTransformation, GrayscaleTransformation
         */

        img_picasso_10 = findViewById(R.id.img_picasso_10);
        img_picasso_11 = findViewById(R.id.img_picasso_11);
        Picasso.with(this)
                .load("http://ww2.sinaimg.cn/large/7a8aed7bjw1ezxog636o8j20du0kujsg.jpg")
                .transform(new ColorFilterTransformation(Color.parseColor("#55ff0000")))
                .into(img_picasso_10);
        Picasso.with(this)
                .load("http://ww2.sinaimg.cn/large/7a8aed7bjw1ezwgshzjpmj21ao1y0tf0.jpg")
                .transform(new GrayscaleTransformation())
                .into(img_picasso_11);

        /**
         * Blur:BlurTransformation
         */
        img_picasso_12 = findViewById(R.id.img_picasso_12);
        Picasso.with(this)
                .load("http://ww2.sinaimg.cn/large/7a8aed7bjw1ezvbmuqz9cj20hs0qoq6o.jpg")
                .transform(new BlurTransformation(PicassoActivity.this))
                .into(img_picasso_12);
        img_picasso_14 = findViewById(R.id.img_picasso_14);
        Picasso.with(this)
                .load("http://ww2.sinaimg.cn/large/7a8aed7bjw1ezvbmuqz9cj20hs0qoq6o.jpg")
                .transform(new BlurTransformation(PicassoActivity.this,20))
                .into(img_picasso_14);

        /**
         * Mask:MaskTransformation
         */
        img_picasso_13 = findViewById(R.id.img_picasso_13);
        img_picasso_15 = findViewById(R.id.img_picasso_15);
        img_picasso_16 = findViewById(R.id.img_picasso_16);
        img_picasso_17 = findViewById(R.id.img_picasso_17);
        Picasso.with(this)
                .load("http://ww4.sinaimg.cn/large/7a8aed7bjw1ezrtpmdv45j20u00spahy.jpg")
                .transform(new MaskTransformation(PicassoActivity.this,R.mipmap.ic_launcher))
                .into(img_picasso_13);
        Picasso.with(this)
                .load("http://ww3.sinaimg.cn/large/7a8aed7bjw1ezplg7s8mdj20xc0m8jwf.jpg")
                .transform(new MaskTransformation(PicassoActivity.this,R.mipmap.chat_me_mask))
                .into(img_picasso_15);
        Picasso.with(this)
                .load("http://ww1.sinaimg.cn/large/7a8aed7bjw1ezn79ievhzj20p00odwhr.jpg")
                .transform(new MaskTransformation(PicassoActivity.this,R.mipmap.mask_starfish))
                .into(img_picasso_16);
        Picasso.with(this)
                .load("http://ww2.sinaimg.cn/large/7a8aed7bjw1ezil3n0cqdj20p00ou776.jpg")
                .transform(new MaskTransformation(PicassoActivity.this,R.mipmap.github))
                .into(img_picasso_17);
        /**
         * GPU Filter (use GPUImage)
         ToonFilterTransformation, SepiaFilterTransformation,
         ContrastFilterTransformation InvertFilterTransformation,
         PixelationFilterTransformation, SketchFilterTransformation SwirlFilterTransformation,
         BrightnessFilterTransformation, KuwaharaFilterTransformation VignetteFilterTransformation
         */
        //
        //
        //img_picasso_18 = findViewById(R.id.img_picasso_18);
        //img_picasso_19 = findViewById(R.id.img_picasso_19);
        //img_picasso_20 = findViewById(R.id.img_picasso_20);
        //img_picasso_21 = findViewById(R.id.img_picasso_21);
        //img_picasso_22 = findViewById(R.id.img_picasso_22);
        //img_picasso_23 = findViewById(R.id.img_picasso_23);
        //img_picasso_24 = findViewById(R.id.img_picasso_24);
        //img_picasso_25 = findViewById(R.id.img_picasso_25);
        //img_picasso_26 = findViewById(R.id.img_picasso_26);
        //img_picasso_27 = findViewById(R.id.img_picasso_27);
        //img_picasso_28 = findViewById(R.id.img_picasso_28);
        //img_picasso_29 = findViewById(R.id.img_picasso_29);
    }

    public void log(String msg) {
        Log.e("123",msg);
    }
}
