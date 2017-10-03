package com.eason.springmvc;

import com.eason.springmvc.filter.MyFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by feng yingsheng on 10/1/2017.
 */
@Slf4j
public class WebInit implements WebApplicationInitializer {


    public void onStartup(ServletContext servletContext) throws ServletException {
        log.info("Web Init now....");
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setServletContext(servletContext);
        context.register(WebMvcConfig.class);
        ServletRegistration.Dynamic servlet =
                servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);

        servlet.setAsyncSupported(Boolean.TRUE);

        log.info("Web Init done....");

    }
}
