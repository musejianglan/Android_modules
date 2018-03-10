package com.promise.floatwindow;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

public class FloatWindowService extends Service {

    private static final String TAG = "123";
    // 定义浮动窗口布局
    View mFloatLayout;
    WindowManager.LayoutParams wmParams;
    // 创建浮动窗口设置布局参数的对象
    WindowManager mWindowManager;
    private FrameLayout smallSizePreviewLayout;

    public FloatWindowService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        try {
            createFloatView();
        } catch (Exception e) {
            e.printStackTrace();
            if (mWindowManager!=null && mFloatLayout!=null) {
                mWindowManager.removeView(mFloatLayout);
            }
            FloatWindowService.this.stopSelf();
        }
    }

    @SuppressLint("NewApi")
    private void createFloatView() throws Exception{
        wmParams = new WindowManager.LayoutParams();
        // 获取WindowManagerImpl.CompatModeWrapper
        mWindowManager = (WindowManager) getApplication().getSystemService(getApplication().WINDOW_SERVICE);
        // 设置window type
        wmParams.type = WindowManager.LayoutParams.TYPE_PHONE;
        // 设置图片格式，效果为背景透明
        wmParams.format = PixelFormat.RGBA_8888;
        // 设置浮动窗口不可聚焦（实现操作除浮动窗口外的其他可见窗口的操作）
        wmParams.flags =
                // LayoutParams.FLAG_NOT_TOUCH_MODAL |
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
        // LayoutParams.FLAG_NOT_TOUCHABLE
        ;

        // 调整悬浮窗显示的停靠位置为左侧置顶
        wmParams.gravity = Gravity.LEFT | Gravity.TOP;

        // 以屏幕左上角为原点，设置x、y初始值
        wmParams.x = 0;
        wmParams.y = 0;

        // 设置悬浮窗口长宽数据
//        wmParams.width = 60;
//        wmParams.height = 100;

        // 设置悬浮窗口长宽数据
         wmParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
         wmParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

        LayoutInflater inflater = LayoutInflater.from(getApplication());
        // 获取浮动窗口视图所在布局
        mFloatLayout =  inflater.inflate(R.layout.float_window_layout, null);
        mFloatLayout.setEnabled(false);
        // 添加mFloatLayout
        mWindowManager.addView(mFloatLayout, wmParams);


        smallSizePreviewLayout = mFloatLayout.findViewById(R.id.small_size_preview);

        //悬浮框点击事件
        smallSizePreviewLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //在这里实现点击重新回到Activity

                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });


        //        //悬浮框触摸事件，设置悬浮框可拖动
        smallSizePreviewLayout.setOnTouchListener(new FloatingListener());



    }

    //开始触控的坐标，移动时的坐标（相对于屏幕左上角的坐标）
    private int mTouchStartX, mTouchStartY, mTouchCurrentX, mTouchCurrentY;
    //开始时的坐标和结束时的坐标（相对于自身控件的坐标）
    private int mStartX, mStartY, mStopX, mStopY;
    //判断悬浮窗口是否移动，这里做个标记，防止移动后松手触发了点击事件
    private boolean isMove;

    private class FloatingListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            int action = event.getAction();
            switch (action) {
                case MotionEvent.ACTION_DOWN:
                    isMove = false;
                    mTouchStartX = (int) event.getRawX();
                    mTouchStartY = (int) event.getRawY();
                    mStartX = (int) event.getX();
                    mStartY = (int) event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    mTouchCurrentX = (int) event.getRawX();
                    mTouchCurrentY = (int) event.getRawY();
                    wmParams.x += mTouchCurrentX - mTouchStartX;
                    wmParams.y += mTouchCurrentY - mTouchStartY;
                    mWindowManager.updateViewLayout(mFloatLayout, wmParams);

                    mTouchStartX = mTouchCurrentX;
                    mTouchStartY = mTouchCurrentY;
                    break;
                case MotionEvent.ACTION_UP:
                    mStopX = (int) event.getX();
                    mStopY = (int) event.getY();
                    if (Math.abs(mStartX - mStopX) >= 1 || Math.abs(mStartY - mStopY) >= 1) {
                        isMove = true;
                    }
                    break;
            }

            //如果是移动事件不触发OnClick事件，防止移动的时候一放手形成点击事件
            return isMove;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mFloatLayout != null) {
            // 移除悬浮窗口
            mWindowManager.removeView(mFloatLayout);
        }

        Log.e(TAG,"service=====>>>>onDestroy");

    }


    @SuppressLint("WrongConstant")
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        //添加下列代码将后台Service变成前台Service
        //构建"点击通知后打开MainActivity"的Intent对象
        Intent notificationIntent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,notificationIntent,0);

        //新建Builer对象
        Notification.Builder builer = new Notification.Builder(this);
        builer.setContentTitle("视频通话中");//设置通知的标题
//        builer.setContentText("前台服务通知的内容");//设置通知的内容
        builer.setSmallIcon(R.mipmap.ic_launcher);//设置通知的图标
        builer.setContentIntent(pendingIntent);//设置点击通知后的操作

        Notification notification = builer.getNotification();//将Builder对象转变成普通的notification
        startForeground(1, notification);//让Service变成前台Service,并在系统的状态栏显示出来

        flags = START_STICKY;
        return super.onStartCommand(intent, flags, startId);
    }
}
