package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.error.RetryWhenMethod;

/**
 * Created by zlove on 2017/10/12.
 */

public class RetryWhenActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new RetryWhenMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
