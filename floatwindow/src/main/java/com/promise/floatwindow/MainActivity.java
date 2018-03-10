package com.promise.floatwindow;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Intent floatIntent;
    private boolean isOpen = false;
    public static int OVERLAY_PERMISSION_REQ_CODE = 1000;

    private SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;
    private MediaPlayer player;//媒体播放器
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        surfaceView = findViewById(R.id.surfaceView);
//        surfaceHolder = surfaceView.getHolder();

//        try {
//            //播放 assets/aaa.mp3 音乐文件
//            AssetFileDescriptor fd = getAssets().openFd("aaa.mp3");
//            player = new MediaPlayer();
//            player.setDataSource(fd.getFileDescriptor(), fd.getStartOffset(), fd.getLength());
//            player.prepare();
//            player.start();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private void openFloatWindow() {
        if (!isOpen) {
            isOpen = true;
            moveTaskToBack(isOpen);//最小化Activity
            floatIntent = new Intent(MainActivity.this,FloatWindowService.class);
            startService(floatIntent);
        }

    }

    private void closeFloatWindow() {
        if (isOpen && floatIntent != null) {
            isOpen = false;
            stopService(floatIntent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == OVERLAY_PERMISSION_REQ_CODE) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(this)) {
                toast("权限授予失败，无法开启悬浮窗");
                MainActivity.this.finish();
            } else {
                toast("权限授予成功！");
                openFloatWindow();
            }

        }
    }


    public void toast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }



    /**
     * 请求用户给予悬浮窗的权限
     */
    public void askForPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(this)) {
                toast("未获取悬浮窗权限，请授权");
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:" + getPackageName()));
                startActivityForResult(intent, OVERLAY_PERMISSION_REQ_CODE);
            } else {
                openFloatWindow();
            }
        }
    }

    public void openFloat(View view) {
        askForPermission();

    }



    public void closeFloat(View view) {
        closeFloatWindow();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        log("====>>>>onRestart");
        closeFloatWindow();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        closeFloatWindow();
//        player.release();
    }

    private void log(String msg){

        Log.e("float",msg);
    }


}
