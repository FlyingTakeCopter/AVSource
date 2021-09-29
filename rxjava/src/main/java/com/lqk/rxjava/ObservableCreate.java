package com.lqk.rxjava;

/**
 * @创建者 lqk
 * @创建时间 2021/9/29 下午4:03
 * @描述 佛祖保佑此文件没有BUG
 */
public class ObservableCreate<T> extends Observable<T> {
    private ObservableOnSubscribe<T> source;

    public ObservableCreate(ObservableOnSubscribe<T> source) {
        this.source = source;
    }

    @Override
    protected void subscribeActual(Observer<? super T> observer) {
        observer.onSubscribe();
    }
}
