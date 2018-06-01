package com.promise.mydialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author: liulei
 * @date:2018/3/29
 */
public class MyDialogFragment extends DialogFragment {
    @BindView(R.id.title) TextView title;
    @BindView(R.id.content) TextView content;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_Holo_Light_Dialog_MinWidth);//使用默认的AlertDialog样式，宽度充满屏幕，左右保留一些外边距
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏

        View view = inflater.inflate(R.layout.dialog_fragment, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    /**
     * 从代码可以看出，首先计算屏幕的宽度，然后将宽度的75%设置到对话框的Window上，高度为WRAP_CONTENT。
     * 记得要在onCreateView方法中加上
     * getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
     */
    @Override
    public void onStart() {
        super.onStart();
//        Dialog dialog = getDialog();
//        if (dialog != null) {
//            DisplayMetrics dm = new DisplayMetrics();
//            getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
//            Window window = dialog.getWindow();
//            window.setBackgroundDrawableResource(android.R.color.transparent);
//            window.setLayout((int) (dm.widthPixels * 0.75), ViewGroup.LayoutParams.WRAP_CONTENT);
//
//        }
    }

    @OnClick(R.id.sure)
    public void sure(){
        this.dismiss();
    }
}
