package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.transform.ConcatMapMethod;

/**
 * Created by zlove on 2017/9/25.
 */

public class ConcatMapActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new ConcatMapMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
