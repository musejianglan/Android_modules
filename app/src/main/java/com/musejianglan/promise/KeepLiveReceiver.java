package com.musejianglan.promise;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class KeepLiveReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {


        String action = intent.getAction();

        if (action.equals(Intent.ACTION_SCREEN_OFF)) {
            context.startActivity(new Intent(context,KeepLiveActivity.class));
        } else if (action.equals(Intent.ACTION_USER_PRESENT)) {

        }
    }
}
