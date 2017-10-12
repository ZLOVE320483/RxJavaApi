package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.error.ExceptionResumeNextMethod;

/**
 * Created by zlove on 2017/10/12.
 */

public class ExceptionResumeNextActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new ExceptionResumeNextMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
