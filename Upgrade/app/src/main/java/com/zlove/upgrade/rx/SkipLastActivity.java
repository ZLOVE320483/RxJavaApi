package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.filter.SkipLastMethod;

/**
 * Created by zlove on 2017/9/30.
 */

public class SkipLastActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new SkipLastMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
