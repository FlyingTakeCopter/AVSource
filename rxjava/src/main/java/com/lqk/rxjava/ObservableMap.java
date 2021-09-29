package com.lqk.rxjava;

/**
 * @创建者 lqk
 * @创建时间 2021/9/29 下午4:04
 * @描述 佛祖保佑此文件没有BUG
 */
public class ObservableMap<T, R> extends Observable<R>{
    private final ObservableSource<T> source;
    private final Function<? super T, ? super R> mFunction;

    public ObservableMap(ObservableSource<T> source, Function<? super T, ? super R> function) {
        this.source = source;
        this.mFunction = function;
    }

    @Override
    protected void subscribeActual(Observer<? super R> observer) {

    }
}
