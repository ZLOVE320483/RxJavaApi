package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.filter.TakeLastMethod;

/**
 * Created by zlove on 2017/9/29.
 */

public class TakeLastActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new TakeLastMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
