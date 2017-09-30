package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.filter.ThrottleMethod;

/**
 * Created by zlove on 2017/9/30.
 */

public class ThrottleActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new ThrottleMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
