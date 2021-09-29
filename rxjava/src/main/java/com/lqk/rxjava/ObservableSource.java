package com.lqk.rxjava;

/**
 * @创建者 lqk
 * @创建时间 2021/9/29 下午3:38
 * @描述 佛祖保佑此文件没有BUG
 */
public interface ObservableSource<T> {
    void subscribe(Observer<? super T> observer);
}
