package com.zlove.upgrade.rx.method.transform;

import android.widget.TextView;

import com.zlove.upgrade.rx.method.SubscribeMethod;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.observables.GroupedObservable;
import rx.schedulers.Schedulers;

/**
 * Created by zlove on 2017/9/26.
 */

public class GroupByMethod implements SubscribeMethod {

    private Observable<GroupedObservable<Boolean, Integer>> observable;
    private Subscriber<GroupedObservable<Boolean, Integer>> subscriber;

    private StringBuilder builder;

    public GroupByMethod(final TextView tvContent) {
        builder = new StringBuilder();

        observable = Observable.just(0, 1, 2, 3, 4, 5).groupBy(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer % 2 == 0;
            }
        });
        subscriber = new Subscriber<GroupedObservable<Boolean, Integer>>() {
            @Override
            public void onCompleted() {
                builder.append("parent---onCompleted---");
                builder.append("\n");
                tvContent.setText(builder.toString());
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(GroupedObservable<Boolean, Integer> groupedObservable) {
                builder.append("parent---onNext---");
                builder.append(groupedObservable);
                builder.append("\n");
                if (groupedObservable.getKey()) {
                    groupedObservable.subscribe(new Subscriber<Integer>() {
                        @Override
                        public void onCompleted() {
                            builder.append("sub---onCompleted---");
                            builder.append("\n");
                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(Integer integer) {
                            builder.append("sub---onNext---");
                            builder.append(integer);
                            builder.append("\n");
                        }
                    });
                }
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
