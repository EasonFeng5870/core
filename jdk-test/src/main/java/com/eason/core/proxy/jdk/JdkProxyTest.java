package com.eason.core.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * Created by fengyingsheng on 2017-9-25.
 */
public class JdkProxyTest {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        HelloServiceHandler proxy = new HelloServiceHandler(helloService);
        helloService = (HelloService) Proxy.newProxyInstance(helloService.getClass().getClassLoader(),
                helloService.getClass().getInterfaces(), proxy);
        helloService.sayHello("zhangsan");
    }

}
