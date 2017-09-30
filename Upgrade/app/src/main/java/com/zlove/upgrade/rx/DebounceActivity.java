package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.filter.DebounceMethod;

/**
 * Created by zlove on 2017/9/27.
 */

public class DebounceActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new DebounceMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
