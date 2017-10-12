package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.combine.JoinMethod;

/**
 * Created by zlove on 2017/10/10.
 */

public class JoinActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new JoinMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
