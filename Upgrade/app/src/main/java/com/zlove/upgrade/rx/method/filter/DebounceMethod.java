package com.zlove.upgrade.rx.method.filter;

import android.widget.TextView;

import com.zlove.upgrade.rx.method.SubscribeMethod;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zlove on 2017/9/27.
 */

public class DebounceMethod implements SubscribeMethod {

    private Observable<Integer> observable;
    private Subscriber<Integer> subscriber;

    private StringBuilder builder;

    public DebounceMethod(final TextView tvContent) {
        builder = new StringBuilder();

        observable = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                int[] nums = {0, 1, 2, 3, 4, 5};
                long[] sleeps = {100, 400, 100, 100, 200, 0};
                for (int i = 0; i < nums.length; i++) {
                    subscriber.onNext(nums[i]);
                    try {
                        Thread.sleep(sleeps[i]);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                subscriber.onCompleted();
            }
        }).debounce(300, TimeUnit.MILLISECONDS);

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
