package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.filter.FilterMethod;

/**
 * Created by zlove on 2017/9/28.
 */

public class FilterActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new FilterMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
