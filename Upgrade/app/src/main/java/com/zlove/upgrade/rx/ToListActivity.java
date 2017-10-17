package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.convert.ToListMethod;

/**
 * Created by zlove on 2017/10/16.
 */

public class ToListActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new ToListMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
