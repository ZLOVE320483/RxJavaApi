package com.zlove.upgrade.rx.method.combine;

import android.widget.TextView;

import com.zlove.upgrade.rx.method.SubscribeMethod;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

/**
 * Created by zlove on 2017/10/9.
 */

public class CombineLatestMethod implements SubscribeMethod {

    private Observable<String> observable;
    private Subscriber<String> subscriber;
    private StringBuilder builder;

    public CombineLatestMethod(final TextView tvContent) {
        builder = new StringBuilder();

        Observable<Integer> observable1 = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                int[] nums = {0, 1, 2,};
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
        Observable<String> observable2 = Observable.just("A", "B", "C", "D");
        observable = Observable.combineLatest(observable1, observable2, new Func2<Integer, String, String>() {
            @Override
            public String call(Integer integer, String s) {
                return s + integer;
            }
        });
        subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                builder.append("onCompleted --- ");
                builder.append("\n");
                tvContent.setText(builder.toString());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                builder.append("onNext --- ");
                builder.append(s);
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
