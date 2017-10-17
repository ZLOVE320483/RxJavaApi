package com.zlove.upgrade.rx.method.convert;

import android.widget.TextView;

import com.zlove.upgrade.rx.method.SubscribeMethod;

import java.util.Map;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by zlove on 2017/10/16.
 */

public class ToMapMethod implements SubscribeMethod {

    private Observable<Map<String, Integer>> observable;
    private Subscriber<Map<String, Integer>> subscriber;
    private StringBuilder builder;

    public ToMapMethod(final TextView tvContent) {
        builder = new StringBuilder();

        observable = Observable.range(0, 3).toMap(new Func1<Integer, String>() {
            @Override
            public String call(Integer integer) {
                return "key" + integer;
            }
        });
        subscriber = new Subscriber<Map<String, Integer>>() {
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
            public void onNext(Map<String, Integer> integer) {
                builder.append("onNext---");
                builder.append(integer);
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
