package com.promise.eventbusdemo.eventbus.event;

/**
 * Created by liulei on 2017/12/25.
 */

public class ToastEvent {

    private String msg;

    public ToastEvent(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
