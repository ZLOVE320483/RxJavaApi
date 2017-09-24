package com.zlove.upgrade.rx.method;

import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ZLOVE on 17/9/23.
 */

public class IntervalMethod implements SubscribeMethod {

    private Observable<Long> observable;
    private Subscriber<Long> subscriber;

    private StringBuilder builder;

    public IntervalMethod(final TextView tvContent) {
        builder = new StringBuilder();
        observable = Observable.interval(1, 2, TimeUnit.SECONDS);

        subscriber = new Subscriber<Long>() {
            @Override
            public void onCompleted() {
                tvContent.setText("onCompleted()");
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(Long o) {
                builder.append("onNext---");
                builder.append(o);
                builder.append("\n");
                tvContent.setText(builder.toString());
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
