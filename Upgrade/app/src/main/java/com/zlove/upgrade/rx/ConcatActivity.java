package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.combine.ConcatMethod;

/**
 * Created by zlove on 2017/10/9.
 */

public class ConcatActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new ConcatMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
