package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.combine.MergeMethod;

/**
 * Created by zlove on 2017/10/9.
 */

public class MergeActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new MergeMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
