package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.filter.LastMethod;

/**
 * Created by zlove on 2017/9/28.
 */

public class LastActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new LastMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
