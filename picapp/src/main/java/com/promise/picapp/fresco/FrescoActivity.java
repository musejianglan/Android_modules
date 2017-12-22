package com.promise.picapp.fresco;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.promise.picapp.R;

public class FrescoActivity extends AppCompatActivity {

    private SimpleDraweeView img_fresco_simple1;
    private SimpleDraweeView img_fresco_simple2;
    private SimpleDraweeView img_fresco_simple3;
    private String uri1 = "http://ww3.sinaimg.cn/large/7a8aed7bgw1evljjs3qxlj20go0gmdiu.jpg0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresco);

        img_fresco_simple1 = findViewById(R.id.img_fresco_simple1);
        img_fresco_simple2 = findViewById(R.id.img_fresco_simple2);
        img_fresco_simple1.setImageURI("http://ww1.sinaimg.cn/large/7a8aed7bgw1evgwbi4o1oj20hq0qomzp.jpg");

        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(uri1)
                .setTapToRetryEnabled(true)//失败点击重新加载，有四次机会，4次加载失败后显示错误图
                .setOldController(img_fresco_simple2.getController())
                //.setControllerListener(listener)
                .build();

        img_fresco_simple2.setController(controller);


        img_fresco_simple3 = findViewById(R.id.img_fresco_simple3);
        img_fresco_simple3.setImageURI("http://ww4.sinaimg.cn/large/7a8aed7bgw1evfqiexncjj20hs0qodj3.jpg");
    }
}
