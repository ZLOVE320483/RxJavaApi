package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.filter.SkipMothed;

/**
 * Created by zlove on 2017/9/30.
 */

public class SkipActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new SkipMothed(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
