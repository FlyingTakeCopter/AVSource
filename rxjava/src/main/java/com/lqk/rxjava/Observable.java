package com.lqk.rxjava;

/**
 * @创建者 lqk
 * @创建时间 2021/9/29 下午3:35
 * @描述 佛祖保佑此文件没有BUG
 */
public abstract class Observable<T> implements ObservableSource<T> {

    public static <T> Observable<T> create(ObservableOnSubscribe<T> observable){
        return new ObservableCreate<>(observable);
    }

    public final <R> Observable<R> map(Function<? super T, ? super R> function){
        return new ObservableMap<T, R>(this, function);
    }

    @Override
    public void subscribe(Observer<? super T> observer) {

    }


    protected abstract void subscribeActual(Observer<? super T> observer);
}
