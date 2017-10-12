package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.combine.CombineLatestMethod;

/**
 * Created by zlove on 2017/10/9.
 */

public class CombineLatestActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new CombineLatestMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
