package com.zlove.upgrade.rx.method.create;

import android.util.Log;
import android.widget.TextView;

import com.zlove.upgrade.rx.method.SubscribeMethod;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func0;
import rx.schedulers.Schedulers;

/**
 * Created by ZLOVE on 17/9/23.
 */

public class DeferMethod implements SubscribeMethod {

    private static final String LOG_TAG = DeferMethod.class.getSimpleName();

    private Observable<String> observable;
    private Subscriber<String> subscriber;

    private String test = "First";

    public DeferMethod(final TextView tvContent) {

        observable = Observable.defer(new Func0<Observable<String>>() {
            @Override
            public Observable<String> call() {
                return Observable.just(test);
            }
        });

        subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                tvContent.setText(test);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(String s) {
                Log.d(LOG_TAG, "onNext --- " + s);
            }
        };

        test = "Second";
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
