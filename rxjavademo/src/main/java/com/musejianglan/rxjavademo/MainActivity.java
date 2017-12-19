package com.musejianglan.rxjavademo;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.musejianglan.rxjavademo.bean.GankFuliBean;
import com.musejianglan.rxjavademo.http.ApiFactory;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    TextView textview;
    ListView listview;
    MeiAdapter meiAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = findViewById(R.id.text_view);
        listview = findViewById(R.id.listview);
        listview.setEmptyView(textview);
        meiAdapter = new MeiAdapter(this);
        listview.setAdapter(meiAdapter);




    }

    public void rx1click(View view) {

        final ProgressDialog progressDialog = ProgressDialog.show(this,"请稍等","网络请求中，请稍等");
        ApiFactory.gitHubAPI().gankFuli()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<GankFuliBean, List<GankFuliBean.ResultsBean>>() {
                    @Override
                    public List<GankFuliBean.ResultsBean> call(GankFuliBean gankFuliBean) {

                        return gankFuliBean.getResults();
                    }
                })
                .subscribe(new Subscriber<List<GankFuliBean.ResultsBean>>() {
                    @Override
                    public void onCompleted() {
                        progressDialog.dismiss();
                    }

                    @Override
                    public void onError(Throwable e) {
                        textview.setText(e.getMessage());
                        progressDialog.dismiss();
                    }

                    @Override
                    public void onNext(List<GankFuliBean.ResultsBean> resultsBeans) {
//                        textview.setText(resultsBeans.size()+"");
                        meiAdapter.setList(resultsBeans);
                    }
                });
    }
}
