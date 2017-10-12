package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.combine.StartWithMethod;

/**
 * Created by zlove on 2017/10/10.
 */

public class StartWithActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new StartWithMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
