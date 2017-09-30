package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.create.RepeatMethod;

/**
 * Created by zlove on 2017/9/25.
 */

public class RepeatActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new RepeatMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
