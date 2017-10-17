package com.zlove.upgrade.rx;

import com.zlove.upgrade.rx.method.convert.ToSortedListMethod;

/**
 * Created by zlove on 2017/10/16.
 */

public class ToSortedListActivity extends BaseRxActivity {

    @Override
    protected void initMethod() {
        method = new ToSortedListMethod(tvContent);
    }

    @Override
    protected void subscribe() {
        method.onClickSubscribe();
    }
}
