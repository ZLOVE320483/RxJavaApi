package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.JustMethod;

/**
 * Created by ZLOVE on 17/9/23.
 */

public class JustActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new JustMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
