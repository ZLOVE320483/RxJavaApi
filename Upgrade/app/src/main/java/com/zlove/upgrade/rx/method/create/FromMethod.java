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

public class FromMethod implements SubscribeMethod {

    private static final String LOG_TAG = FromMethod.class.getSimpleName();

    private String[] test = {"I", "LOVE", "U"};

    private Observable<String> observable;
    private Subscriber<String> subscriber;
    private StringBuilder builder;

    public FromMethod(final TextView tvContent) {
        builder = new StringBuilder();

        observable = Observable.from(test);

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
                Log.d(LOG_TAG, "onNext --- " + s);
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
