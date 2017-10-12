package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.error.ErrorReturnMethod;

/**
 * Created by zlove on 2017/10/12.
 */

public class ErrorReturnActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new ErrorReturnMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
