/*
 * Copyright (c) 2018.
 *
 */

package com.promise.mydialog;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author: liulei
 * @date:2018/3/29
 */
public class CustomSysDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_fragment, null);
        ButterKnife.bind(this, view);
        builder.setView(view);


        return builder.create();
    }

    @OnClick(R.id.sure)
    public void sure(){
        this.dismiss();

    }
}
