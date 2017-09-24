package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.RangeMethod;

/**
 * Created by ZLOVE on 17/9/24.
 */

public class RangeActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new RangeMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
