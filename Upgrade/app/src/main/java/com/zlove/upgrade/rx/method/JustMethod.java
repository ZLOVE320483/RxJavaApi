package com.zlove.upgrade.rx.method;

import android.widget.TextView;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ZLOVE on 17/9/23.
 */

public class JustMethod implements SubscribeMethod {

    private String[] test = {"I", "LOVE", "U"};

    private Observable<String[]> observable;
    private Subscriber<String[]> subscriber;

    private StringBuilder builder;

    public JustMethod(final TextView tvContent) {
        builder = new StringBuilder();
        subscriber = new Subscriber<String[]>() {
            @Override
            public void onCompleted() {
                tvContent.setText(builder.toString());
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(String[] strings) {
                for (int i = 0; i < strings.length; i++) {
                    builder.append(strings[i]);
                }
            }
        };

        observable = Observable.just(test);
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
