package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.filter.SingleMethod;

/**
 * Created by zlove on 2017/9/28.
 */

public class SingleActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new SingleMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
