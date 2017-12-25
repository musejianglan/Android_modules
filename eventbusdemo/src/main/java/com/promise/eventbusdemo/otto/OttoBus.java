package com.promise.eventbusdemo.otto;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * Created by liulei on 2017/12/25.
 */

public class OttoBus extends Bus {

    private static Bus mOttoBus;


    private OttoBus() {

        //super(ThreadEnforcer.ANY);
    }

    public static Bus getInstance(){
        if (mOttoBus == null) mOttoBus = new Bus(ThreadEnforcer.ANY);
        //if (mOttoBus == null) mOttoBus = new Bus();
        return mOttoBus;
    }


}
