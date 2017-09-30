package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.transform.MapMethod;

/**
 * Created by zlove on 2017/9/25.
 */

public class MapActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new MapMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
