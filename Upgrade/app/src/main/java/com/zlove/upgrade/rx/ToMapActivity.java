package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.convert.ToMapMethod;

/**
 * Created by zlove on 2017/10/16.
 */

public class ToMapActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new ToMapMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
