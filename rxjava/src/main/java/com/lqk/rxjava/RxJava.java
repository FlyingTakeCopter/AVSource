package com.lqk.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @创建者 lqk
 * @创建时间 2021/9/29 下午2:47
 * @描述 佛祖保佑此文件没有BUG
 */
public class RxJava {
    public void test() {
        ObservableOnSubscribe<String> observableOnSubscribe = new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {

            }
        };

        Function<String, String> function = new Function<String, String>() {
            @Override
            public String apply(String s) throws Exception {
                return s;
            }
        };

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String value) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        Observable.create(observableOnSubscribe)
        .map(function)
        .subscribe(observer);
    }
}
