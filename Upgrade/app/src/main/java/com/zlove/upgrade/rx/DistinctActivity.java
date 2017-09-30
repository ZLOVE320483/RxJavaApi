package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.filter.DistinctMethhod;

/**
 * Created by zlove on 2017/9/28.
 */

public class DistinctActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new DistinctMethhod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
