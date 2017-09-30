package com.zlove.upgrade.rx.method.transform;

import android.widget.TextView;

import com.zlove.upgrade.rx.method.SubscribeMethod;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by zlove on 2017/9/25.
 */

public class MapMethod implements SubscribeMethod {

    private Observable<String> observable;
    private Subscriber<String> subscriber;

    private StringBuilder builder;

    public MapMethod(final TextView tvContent) {
        builder = new StringBuilder();

        observable = Observable.just(1, 2, 3).map(new Func1<Integer, String>() {
            @Override
            public String call(Integer integer) {
                return "call --- " + integer;
            }
        });

        subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                builder.append("---onCompleted---");
                builder.append("\n");
                tvContent.setText(builder.toString());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                builder.append("onNext----");
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
