package com.zlove.upgrade.rx.method.combine;

import android.widget.TextView;

import com.zlove.upgrade.rx.method.SubscribeMethod;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zlove on 2017/10/10.
 */

public class StartWithMethod implements SubscribeMethod {

    private Observable<Integer> observable;
    private Subscriber<Integer> subscriber;
    private StringBuilder builder;

    public StartWithMethod(final TextView tvContent) {
        builder = new StringBuilder();

        Observable<Integer> observable2 = Observable.just(0, 1, 2);
        observable = observable2.startWith(3, 4, 5);

        subscriber = new Subscriber<Integer>() {
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
