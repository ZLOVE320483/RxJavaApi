package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.transform.BufferMethod;

/**
 * Created by zlove on 2017/9/25.
 */

public class BufferActivity extends BaseRxActivity {
    @Override
    protected void initMethod() {
        method = new BufferMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
