package com.zlove.upgrade.rx.method.transform;

import android.widget.TextView;

import com.zlove.upgrade.rx.method.SubscribeMethod;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by zlove on 2017/9/25.
 */

public class ConcatMapMethod implements SubscribeMethod {

    private Observable<String> observable;
    private Subscriber<String> subscriber;

    private StringBuilder builder;

    public ConcatMapMethod(final TextView tvContent) {
        builder = new StringBuilder();

        observable = Observable.just(1, 2, 3).concatMap(new Func1<Integer, Observable<? extends String>>() {
            @Override
            public Observable<? extends String> call(Integer integer) {
                int delay = 2 - integer;
                return Observable.just("A" + integer).delay(delay, TimeUnit.SECONDS);
            }
        });

        subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                builder.append("onCompleted --- ");
                builder.append("\n");
                tvContent.setText(builder.toString());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                builder.append("onNext --- ");
                builder.append(s);
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
