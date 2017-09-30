package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.filter.DistinctUntilChangedMethod;

/**
 * Created by zlove on 2017/9/28.
 */

public class DistinctUntilChangedActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new DistinctUntilChangedMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
