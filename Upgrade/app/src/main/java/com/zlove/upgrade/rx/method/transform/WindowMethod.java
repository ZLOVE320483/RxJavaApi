package com.zlove.upgrade.rx.method.transform;

import android.widget.TextView;

import com.zlove.upgrade.rx.method.SubscribeMethod;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zlove on 2017/9/25.
 */

public class WindowMethod implements SubscribeMethod {

    private Observable<Observable<Integer>> observable;
    private Subscriber<Observable<Integer>> subscriber;

    private StringBuilder builder;

    public WindowMethod(final TextView tvContent) {
        builder = new StringBuilder();

        observable = Observable.just(1, 2, 3).window(2);

        subscriber = new Subscriber<Observable<Integer>>() {
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
            public void onNext(Observable<Integer> o) {
                builder.append("onNext----");
                builder.append(o.toString());
                builder.append("\n");
                o.subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                        builder.append("sub---onCompleted---");
                        builder.append("\n");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        builder.append("sub---onNext----");
                        builder.append(integer);
                        builder.append("\n");
                    }
                });
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
