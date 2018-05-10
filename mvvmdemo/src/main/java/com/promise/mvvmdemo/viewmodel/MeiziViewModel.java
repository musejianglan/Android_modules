package com.promise.mvvmdemo.viewmodel;

import android.app.Activity;

import com.promise.mvvmdemo.bean.BaseResult;
import com.promise.mvvmdemo.bean.Meizi;
import com.promise.mvvmdemo.http.interfaces.IResult;
import com.promise.mvvmdemo.model.MeizhiModel;
import com.promise.mvvmdemo.view.adapter.MeizhiAdapter;

import java.util.List;

/**
 * @author: liulei
 * @date:2018/5/10
 */
public class MeiziViewModel {

    private Activity mActivity;
    private MeizhiModel meizhiModel;
    private MeizhiAdapter meizhiAdapter;

    public MeiziViewModel(Activity mActivity,  MeizhiAdapter meizhiAdapter) {
        this.mActivity = mActivity;
        this.meizhiModel = new MeizhiModel();
        this.meizhiAdapter = meizhiAdapter;
    }

    public void getData(){
        meizhiModel.getNewMeizhiData(new IResult<BaseResult<List<Meizi>>>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onFail(Throwable e) {

            }

            @Override
            public void onSuccess(BaseResult<List<Meizi>> response) {
                meizhiAdapter.setmList(response.getResults());
            }
        });
    }
}
