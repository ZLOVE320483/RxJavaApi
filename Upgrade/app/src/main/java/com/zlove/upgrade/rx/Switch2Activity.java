package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.combine.SwitchMethod;

/**
 * Created by zlove on 2017/10/10.
 */

public class Switch2Activity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new SwitchMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
