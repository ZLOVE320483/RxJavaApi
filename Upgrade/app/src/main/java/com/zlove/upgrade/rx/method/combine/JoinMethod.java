package com.zlove.upgrade.rx.method.combine;

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
 * Created by zlove on 2017/10/10.
 */

public class JoinMethod implements SubscribeMethod {

    private Observable<String> observable;
    private Subscriber<String> subscriber;
    private StringBuilder builder;

    public JoinMethod(final TextView tvContent) {
        builder = new StringBuilder();

        Observable<Integer> observable2 = Observable.just(0, 1, 2);
        Observable<String> observable3 = Observable.just("A", "B", "C", "D");
        observable = observable2.join(observable3, new Func1<Integer, Observable<Integer>>() {
            @Override
            public Observable<Integer> call(Integer integer) {
                return Observable.just(integer).delay(200, TimeUnit.MILLISECONDS);
            }
        }, new Func1<String, Observable<String>>() {
            @Override
            public Observable<String> call(String s) {
                return Observable.just(s).delay(150, TimeUnit.MILLISECONDS);
            }
        }, new Func2<Integer, String, String>() {
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
