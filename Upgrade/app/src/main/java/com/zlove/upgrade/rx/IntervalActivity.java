package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.IntervalMethod;

/**
 * Created by ZLOVE on 17/9/23.
 */

public class IntervalActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new IntervalMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
