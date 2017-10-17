package com.zlove.upgrade.rx.method.convert;

import android.widget.TextView;

import com.zlove.upgrade.rx.method.SubscribeMethod;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zlove on 2017/10/16.
 */

public class ToListMethod implements SubscribeMethod {

    private Observable<List<Integer>> observable;
    private Subscriber<List<Integer>> subscriber;

    private StringBuilder builder;

    public ToListMethod(final TextView tvContent) {
        builder = new StringBuilder();

        observable = Observable.range(0, 3).toList();
        subscriber = new Subscriber<List<Integer>>() {
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
            public void onNext(List<Integer> integer) {
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
