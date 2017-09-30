package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.filter.IgnoreElementsMethod;

/**
 * Created by zlove on 2017/9/30.
 */

public class IgnoreElementsActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new IgnoreElementsMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
