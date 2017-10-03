package com.eason.payment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by feng yingsheng on 9/30/2017.
 */
@Component("springComponent")
public class SpringComponent {

    public void test() {
        System.out.println(1);
        System.out.println(a);
    }

    @Value("${a}")
    private String a;
}
