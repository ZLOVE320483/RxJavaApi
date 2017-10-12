package com.zlove.upgrade.rx.method.combine;

import android.widget.TextView;

import com.zlove.upgrade.rx.method.SubscribeMethod;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zlove on 2017/10/9.
 */

public class MergeMethod implements SubscribeMethod {

    private Observable<Integer> observable;
    private Subscriber<Integer> subscriber;
    private StringBuilder builder;

    public MergeMethod(final TextView tvContent) {
        builder = new StringBuilder();

        Observable<Integer> observable1 = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                int[] nums = {0, 1, 2};
                long[] sleeps = {500, 500, 0};
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
        });
        Observable<Integer> observable2 = Observable.just(3, 4, 5);
        observable = Observable.merge(observable1, observable2);
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
