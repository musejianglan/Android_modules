package com.musejianglan.rxjavademo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.musejianglan.rxjavademo.bean.Translation;
import com.musejianglan.rxjavademo.http.ApiFactory;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class GsonActivity extends AppCompatActivity {

    private TextView txt;
    private TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);
        txt = findViewById(R.id.txt);
        textView2 = findViewById(R.id.textView2);
    }

    public void toGsonString(View view) {

        Translation translation = new Translation(20,new Translation.ContentBean("china","english","你好","hello",
                50));

        textView2.setText(translation.toString());
        txt.setText(new Gson().toJson(translation));
    }

    public void toObject(View view) {

        ApiFactory.gitHubAPI().gankFuli()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {

                        if (responseBody != null) {
                            try {
                                String string = responseBody.string();
                                //txt.setText(string);
                                //GankFuliBean gankFuliBean = new Gson().fromJson(string, GankFuliBean.class);
                                //textView2.setText(gankFuliBean.isError()+"---"+gankFuliBean.getResults().size());

                                //Gson gson = new Gson();
                                //gson.
                                JsonObject returnData = new JsonParser().parse(string).getAsJsonObject();
                                boolean name = returnData.has("name");
                                txt.setText(name+""+returnData.has("error"));

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
