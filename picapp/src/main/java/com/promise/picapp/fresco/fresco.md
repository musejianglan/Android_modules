### SimpleDraweeView

> 必须声明 android:layout_width 和 android:layout_height,不支持 wrap_content 属性。

* 设置宽高比
```
mSimpleDraweeView.setAspectRatio(1.33f);

fresco:viewAspectRatio="1.33"  固定宽高比（宽/高），例如设置宽位20dp 高需要设置为wrap_content，自动计算高度

```

```
    fresco:actualImageResource=""
    fresco:actualImageUri=""
    fresco:roundBottomEnd=""
    fresco:roundBottomStart=""
    fresco:roundingBorderPadding=""
    fresco:roundTopEnd=""
    fresco:roundTopStart=""
    fresco:viewAspectRatio="1.33"  固定宽高比（宽/高），例如设置宽位20dp 高需要设置为wrap_content，自动计算高度
     fresco:fadeDuration="300"
      fresco:actualImageScaleType="focusCrop"
      fresco:placeholderImage="@color/wait_color"   占位图
      fresco:placeholderImageScaleType="fitCenter"
      fresco:failureImage="@drawable/error"
      fresco:failureImageScaleType="centerInside"
      fresco:retryImage="@drawable/retrying" //失败重试图，点击冲洗加载
      fresco:retryImageScaleType="centerCrop"
      fresco:progressBarImage="@drawable/progress_bar"
      fresco:progressBarImageScaleType="centerInside"
      fresco:progressBarAutoRotateInterval="1000"
      fresco:backgroundImage="@color/blue"
      fresco:overlayImage="@drawable/watermark"
      fresco:pressedStateOverlayImage="@color/red"
      fresco:roundAsCircle="false"
      fresco:roundedCornerRadius="1dp"
      fresco:roundTopLeft="true"
      fresco:roundTopRight="false"
      fresco:roundBottomLeft="false"
      fresco:roundBottomRight="true"
      fresco:roundWithOverlayColor="@color/corner_color"
      fresco:roundingBorderWidth="2dp"
      fresco:roundingBorderColor="@color/border_color"

```