package com.zlove.upgrade.rx.method.filter;

import android.widget.TextView;

import com.zlove.upgrade.rx.method.SubscribeMethod;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zlove on 2017/9/28.
 */

public class TakeMethod implements SubscribeMethod {

    private Observable<Long> observable;
    private Subscriber<Long> subscriber;

    private StringBuilder builder;

    public TakeMethod(final TextView tvContent) {
        builder = new StringBuilder();

        observable = Observable.interval(200, TimeUnit.MILLISECONDS).take(1001, TimeUnit.MILLISECONDS);
        subscriber = new Subscriber<Long>() {
            @Override
            public void onCompleted() {
                builder.append("onCompleted---");
                builder.append("\n");
                tvContent.setText(builder.toString());
            }

            @Override
            public void onError(Throwable e) {
                builder.append("onError()---");
                builder.append(e.getMessage());
                builder.append("\n");
                tvContent.setText(builder.toString());
            }

            @Override
            public void onNext(Long o) {
                builder.append("onNext---");
                builder.append(o);
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
