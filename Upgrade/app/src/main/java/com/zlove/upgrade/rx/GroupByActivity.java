package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.transform.GroupByMethod;

/**
 * Created by zlove on 2017/9/26.
 */

public class GroupByActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new GroupByMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
