package com.lqk.rxjava;

/**
 * @创建者 lqk
 * @创建时间 2021/9/29 下午3:36
 * @描述 佛祖保佑此文件没有BUG
 */
public interface Function<T, R> {
    R apply(T t) throws Exception;
}
