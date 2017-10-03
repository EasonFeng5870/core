package com.eason.springmvc.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by feng yingsheng on 10/3/2017.
 */
@Slf4j
@WebListener(value = "myListener")
public class MyListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        log.info("session created is detacted now...");
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        log.info("MyListener session destoryed is detacted now....");
    }
}
