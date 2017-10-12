package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.combine.ZipMethod;

/**
 * Created by zlove on 2017/10/9.
 */

public class ZipActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new ZipMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
