package com.promise.architecturecomponents.viewModel.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

/**
 * @author: liulei
 * @date:2018/5/11
 */
public class NameViewModel extends ViewModel {


    private MutableLiveData<String> nameMutableLiveData;

    private MutableLiveData<List<String>> mNameListData;

    public LiveData<String> getNameMutableLiveData() {
        if (nameMutableLiveData == null) {
            nameMutableLiveData = new MutableLiveData<>();




            nameMutableLiveData.setValue("11111111111111111");


        }
        return nameMutableLiveData;
    }

    public LiveData<List<String>> getmNameListData() {
        if (mNameListData == null) {
            mNameListData = new MutableLiveData<>();
        }
        return mNameListData;
    }


}
