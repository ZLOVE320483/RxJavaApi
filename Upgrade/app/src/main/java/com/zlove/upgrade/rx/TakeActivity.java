package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.filter.TakeMethod;

/**
 * Created by zlove on 2017/9/28.
 */

public class TakeActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new TakeMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
