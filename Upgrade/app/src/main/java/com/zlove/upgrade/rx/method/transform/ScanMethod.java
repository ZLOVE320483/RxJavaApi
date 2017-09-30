package com.zlove.upgrade.rx.method.transform;

import android.widget.TextView;

import com.zlove.upgrade.rx.method.SubscribeMethod;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

/**
 * Created by zlove on 2017/9/26.
 */

public class ScanMethod implements SubscribeMethod {

    private Observable<String> observable;
    private Subscriber<String> subscriber;

    private StringBuilder builder;

    public ScanMethod(final TextView tvContent) {
        builder = new StringBuilder();

        observable = Observable.just("A", "B", "C").scan(new Func2<String, String, String>() {
            @Override
            public String call(String s, String s2) {
                return s + s2;
            }
        });

        subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                builder.append("onCompleted---");
                builder.append("\n");
                tvContent.setText(builder.toString());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                builder.append("onNext---");
                builder.append(s);
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
