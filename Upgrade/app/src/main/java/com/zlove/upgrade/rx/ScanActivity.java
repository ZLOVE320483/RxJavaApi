package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.transform.ScanMethod;

/**
 * Created by zlove on 2017/9/26.
 */

public class ScanActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new ScanMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
