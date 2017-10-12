package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.error.ErrorResumeNextMethod;

/**
 * Created by zlove on 2017/10/12.
 */

public class ErrorResumeNextActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new ErrorResumeNextMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
