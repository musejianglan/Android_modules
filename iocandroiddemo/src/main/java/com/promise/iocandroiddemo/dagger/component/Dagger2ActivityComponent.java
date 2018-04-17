package com.promise.iocandroiddemo.dagger.component;

import com.promise.iocandroiddemo.dagger.Dagger2Activity;

import dagger.Component;

/**
 * @author: liulei
 * @date:2018/4/17
 */
@Component
public interface Dagger2ActivityComponent {

    void inject(Dagger2Activity dagger2Activity);
}
