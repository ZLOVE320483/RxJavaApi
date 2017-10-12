package com.zlove.upgrade.rx.method.error;

import android.widget.TextView;

import com.zlove.upgrade.rx.method.SubscribeMethod;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by zlove on 2017/10/11.
 */

public class ErrorReturnMethod implements SubscribeMethod {

    private Observable<Integer> observable;
    private Subscriber<Integer> subscriber;
    private StringBuilder builder;

    public ErrorReturnMethod(final TextView tvContent) {
        builder = new StringBuilder();

        observable = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                subscriber.onError(new Error("Test Error"));
            }
        }).onErrorReturn(new Func1<Throwable, Integer>() {
            @Override
            public Integer call(Throwable throwable) {
                return 999;
            }
        });

        subscriber = new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                builder.append("onCompleted---");
                builder.append("\n");
                tvContent.setText(builder.toString());
            }

            @Override
            public void onError(Throwable e) {
                builder.append("onError() ");
                builder.append(e.getMessage());
                builder.append("\n");
                tvContent.setText(builder);
            }

            @Override
            public void onNext(Integer integer) {
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
