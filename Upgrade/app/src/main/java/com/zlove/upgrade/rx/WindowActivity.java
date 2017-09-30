package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.transform.WindowMethod;

/**
 * Created by zlove on 2017/9/25.
 */

public class WindowActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new WindowMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
