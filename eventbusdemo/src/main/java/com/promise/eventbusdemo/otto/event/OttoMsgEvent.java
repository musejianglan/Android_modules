package com.promise.eventbusdemo.otto.event;

/**
 * Created by liulei on 2017/12/25.
 */

public class OttoMsgEvent {

    private String msg;

    public OttoMsgEvent(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
