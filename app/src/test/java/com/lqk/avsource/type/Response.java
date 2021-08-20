package com.lqk.avsource.type;

public class Response<T> {
    protected Response() {
        System.out.println("Response init");
    }

    T data;

    public void test() {
        System.out.println("test0");
    }

}
