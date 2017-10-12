package com.zlove.upgrade.rx.method.error;

import android.widget.TextView;

import com.zlove.upgrade.rx.method.SubscribeMethod;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

/**
 * Created by zlove on 2017/10/12.
 */

public class RetryWhenMethod implements SubscribeMethod {

    private Observable<Integer> observable;
    private Subscriber<Integer> subscriber;
    private StringBuilder builder;

    public RetryWhenMethod(final TextView tvContent) {
        builder = new StringBuilder();

        observable = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                builder.append("subscriber.onNext(1)\n");
                subscriber.onNext(1);
                int error = 1 / 0;
            }
        }).retryWhen(new Func1<Observable<? extends Throwable>, Observable<?>>() {
            @Override
            public Observable<?> call(Observable<? extends Throwable> observable) {
                return observable.zipWith(Observable.range(1, 3), new Func2<Throwable, Integer, Integer>() {
                    @Override
                    public Integer call(Throwable throwable, Integer integer) {
                        return integer;
                    }
                }).flatMap(new Func1<Integer, Observable<?>>() {
                    @Override
                    public Observable<?> call(Integer o) {
                        return Observable.timer(100 * o, TimeUnit.MILLISECONDS);
                    }
                });
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
