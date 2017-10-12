package com.zlove.upgrade.rx.method.combine;

import android.widget.TextView;

import com.zlove.upgrade.rx.method.SubscribeMethod;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

/**
 * Created by zlove on 2017/10/3.
 */

public class ZipMethod implements SubscribeMethod {

    private Observable<String> observable;
    private Observable<Integer> observable2;
    private Observable<String> observable3;
    private Subscriber<String> subscriber;
    private StringBuilder builder;

    public ZipMethod(final TextView tvContent) {
        builder = new StringBuilder();
        observable2 = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                int[] nums = {0, 1, 2};
                long[] sleeps = {500, 500, 500};
                for (int i = 0; i < nums.length; i++) {
                    try {
                        Thread.sleep(sleeps[i]);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    subscriber.onNext(nums[i]);
                }
                subscriber.onCompleted();
            }
        });
        observable3 = Observable.just("A", "B", "C", "D");
        observable = Observable.zip(observable2, observable3, new Func2<Integer, String, String>() {
            @Override
            public String call(Integer integer, String s) {
                return s + integer;
            }
        });

        subscriber = new Subscriber<String>() {
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
            public void onNext(String s) {
                builder.append("onNext---");
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
