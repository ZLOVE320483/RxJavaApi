package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.create.CreateMethod;

/**
 * Created by ZLOVE on 17/9/22.
 */

public class CreateActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new CreateMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
