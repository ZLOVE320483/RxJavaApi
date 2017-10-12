package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.error.RetryMethod;

/**
 * Created by zlove on 2017/10/12.
 */

public class RetryActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new RetryMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
