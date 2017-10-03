package com.eason.payment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by feng yingsheng on 10/1/2017.
 */
public class WebInit implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println(servletContext.getMajorVersion());
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.setConfigLocation("com.eason.payment");

        servletContext.addListener(new ContextLoaderListener(applicationContext));

        ServletRegistration.Dynamic dispath = servletContext.addServlet("dispatcher", new DispatcherServlet(applicationContext));

        dispath.setLoadOnStartup(1);;
        dispath.addMapping("/");

    }
}
