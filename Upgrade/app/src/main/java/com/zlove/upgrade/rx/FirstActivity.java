package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.filter.FirstMethod;

/**
 * Created by zlove on 2017/9/28.
 */

public class FirstActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new FirstMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
