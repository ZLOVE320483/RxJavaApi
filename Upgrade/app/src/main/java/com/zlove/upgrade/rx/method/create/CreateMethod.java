package com.zlove.upgrade.rx.method.create;

import android.util.Log;
import android.widget.TextView;

import com.zlove.upgrade.rx.method.SubscribeMethod;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ZLOVE on 17/9/23.
 */

public class CreateMethod implements SubscribeMethod {

    private static final String LOG_TAG = CreateMethod.class.getSimpleName();

    private Observable<String> observable;
    private Observable.OnSubscribe<String> subscribe;
    private Subscriber<String> subscriber;

    private StringBuilder builder;

    public CreateMethod(final TextView tvContent) {
        builder = new StringBuilder();

        subscribe = new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello World!");
                subscriber.onNext(" ");
                subscriber.onNext("I Love Java");
                subscriber.onCompleted();
            }
        };
        observable = Observable.create(subscribe);

        subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                tvContent.setText(builder.toString());
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public void onNext(String s) {
                Log.d(LOG_TAG, "onNext --- s --- " + s);
                builder.append(s);
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
