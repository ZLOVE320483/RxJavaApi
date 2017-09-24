package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.DeferMethod;

/**
 * Created by ZLOVE on 17/9/23.
 */

public class DeferActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new DeferMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
