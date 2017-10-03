package com.eason.springmvc.util;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.util.Properties;

/**
 * this is for get bean from spring ioc container
 *
 * Created by feng ying sheng on 2015/11/17.
 */
public class AppContextHolder {

    private static ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(
            ContextLoaderListener.getCurrentWebApplicationContext().getServletContext());

    /**
     * abstract method for get the corresponding bean
     * @param beanName
     * @param <T>
     * @return
     */
    public static <T> T getBean(String beanName){
        return (T) ac.getBean(beanName);
    }
    public static <T> T getBean(String beanName,Class<T>  classz){
        return (T) ac.getBean(beanName, classz);
    }

}
