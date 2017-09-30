package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.filter.ElementAtMethod;

/**
 * Created by zlove on 2017/9/28.
 */

public class ElementAtActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new ElementAtMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
