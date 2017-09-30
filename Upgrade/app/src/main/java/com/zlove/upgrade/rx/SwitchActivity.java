package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.transform.SwitchMethod;

/**
 * Created by zlove on 2017/9/25.
 */

public class SwitchActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new SwitchMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
