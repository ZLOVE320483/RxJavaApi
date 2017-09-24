package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.FromMethod;

/**
 * Created by ZLOVE on 17/9/23.
 */

public class FromActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new FromMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
