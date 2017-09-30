package com.eason.core.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by fengyingsheng on 2017-9-25.
 */
public class HelloServiceHandler implements InvocationHandler {

    private Object target;

    public HelloServiceHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.before();
        Object res = method.invoke(this.target, args);
        this.end();
        return res;
    }

    private void end() {
        System.out.println("aspect after  ...");
    }

    private void before() {
        System.out.println("aspect before ...");
    }
}
