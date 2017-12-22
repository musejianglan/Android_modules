package com.promise.picapp.glide;

import android.content.Context;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.module.GlideModule;

/**
 * Created by liulei on 2017/12/22.
 */

public class MyGlideModule implements GlideModule {
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        //builder.setBitmapPool()
        //builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
        //builder.setDiskCache();
        //builder.setDiskCacheService()
        //builder.setMemoryCache()
        //builder.setResizeService()
        Log.e("123","argb-----8888");

        MemorySizeCalculator calculator = new MemorySizeCalculator(context);
        int defaultMemoryCacheSize = calculator.getMemoryCacheSize();
        int defaultBitmapPoolSize = calculator.getBitmapPoolSize();

        int customMemoryCacheSize = (int) (1.2 * defaultMemoryCacheSize);
        int customBitmapPoolSize = (int) (1.2 * defaultBitmapPoolSize);

        builder.setMemoryCache( new LruResourceCache( customMemoryCacheSize ));
        builder.setBitmapPool( new LruBitmapPool( customBitmapPoolSize ));

        //默认值作为基线并调整，上面的代码是非常有用的。例如，如果你想要你的app比默认多20%的缓存，使用上面的变量来计算它们：

        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);

        // set size & external vs. internal
        int cacheSize100MegaBytes = 104857600;
        builder.setDiskCache(new InternalCacheDiskCacheFactory(context, cacheSize100MegaBytes));
        //builder.setDiskCache(new ExternalCacheDiskCacheFactory(context, cacheSize100MegaBytes));

    }

    @Override
    public void registerComponents(Context context, Glide glide) {

    }
}
