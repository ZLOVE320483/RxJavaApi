package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.TimerMethod;

/**
 * Created by ZLOVE on 17/9/24.
 */

public class TimerActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new TimerMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
