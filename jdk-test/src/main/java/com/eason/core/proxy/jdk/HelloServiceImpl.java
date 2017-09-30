package com.eason.core.proxy.jdk;

/**
 * Created by fengyingsheng on 2017-9-25.
 */
public class HelloServiceImpl implements HelloService {

    public void sayHello(String name) {
        System.out.println(name + ", 你好");
    }
}
