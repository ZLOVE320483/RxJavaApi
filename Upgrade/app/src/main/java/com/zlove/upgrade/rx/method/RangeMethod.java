package com.zlove.upgrade.rx.method;

import android.widget.TextView;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ZLOVE on 17/9/24.
 */

public class RangeMethod implements SubscribeMethod {

    private Observable<Integer> observable;
    private Subscriber<Integer> subscriber;

    private StringBuilder builder;

    public RangeMethod(final TextView tvContent) {
        builder = new StringBuilder();

        observable = Observable.range(1, 5);

        subscriber = new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                builder.append("onCompleted---");
                tvContent.setText(builder.toString());
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(Integer integer) {
                builder.append("onNext---");
                builder.append(integer);
                builder.append("\n");
            }
        };
    }

    @Override
    public void onClickSubscribe() {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    @Override
    public void unsubscribe() {
        subscriber.unsubscribe();
    }
}
