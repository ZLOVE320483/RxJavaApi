package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.transform.FlatMapMethod;

/**
 * Created by zlove on 2017/9/25.
 */

public class FlatMapActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new FlatMapMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
