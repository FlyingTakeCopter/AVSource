package com.lqk.rxjava;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * @创建者 lqk
 * @创建时间 2021/9/29 下午3:35
 * @描述 佛祖保佑此文件没有BUG
 */
public interface Observer<T> {

    /**
     * Provides the Observer with the means of cancelling (disposing) the
     * connection (channel) with the Observable in both
     * synchronous (from within {@link #onNext(Object)}) and asynchronous manner.
     * @param d the Disposable instance whose {@link Disposable#dispose()} can
     * be called anytime to cancel the connection
     * @since 2.0
     */
    void onSubscribe(Disposable d);

    /**
     * Provides the Observer with a new item to observe.
     * <p>
     * The {@link io.reactivex.Observable} may call this method 0 or more times.
     * <p>
     * The {@code Observable} will not call this method again after it calls either {@link #onComplete} or
     * {@link #onError}.
     *
     * @param value
     *          the item emitted by the Observable
     */
    void onNext(T value);

    /**
     * Notifies the Observer that the {@link io.reactivex.Observable} has experienced an error condition.
     * <p>
     * If the {@link io.reactivex.Observable} calls this method, it will not thereafter call {@link #onNext} or
     * {@link #onComplete}.
     *
     * @param e
     *          the exception encountered by the Observable
     */
    void onError(Throwable e);

    /**
     * Notifies the Observer that the {@link io.reactivex.Observable} has finished sending push-based notifications.
     * <p>
     * The {@link Observable} will not call this method if it calls {@link #onError}.
     */
    void onComplete();
}
