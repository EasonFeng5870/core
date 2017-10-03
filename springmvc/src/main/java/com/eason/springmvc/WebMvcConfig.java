package com.eason.springmvc;

import com.eason.springmvc.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by feng yingsheng on 10/1/2017.
 */
@Configuration
@EnableWebMvc
@PropertySource(value = "classpath:env.properties", ignoreResourceNotFound = true)
@ComponentScan("com.eason.springmvc")
@EnableScheduling
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setOrder(2);
        return viewResolver;
    }

    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
        ContentNegotiatingViewResolver viewResolver = new ContentNegotiatingViewResolver();
        viewResolver.setContentNegotiationManager(manager);
        List<ViewResolver> resolvers = new ArrayList<>();
        resolvers.add(jsonViewResolver());
        resolvers.add(viewResolver());
        viewResolver.setViewResolvers(resolvers);
        return viewResolver;
    }

    @Bean
    public ViewResolver jsonViewResolver() {
        ViewResolver jsonViewResolver = new ViewResolver() {
            @Override
            public View resolveViewName(String viewName, Locale locale) throws Exception {
                MappingJackson2JsonView mappingJackson2JsonView = new MappingJackson2JsonView();
                mappingJackson2JsonView.setPrettyPrint(Boolean.TRUE);
                return mappingJackson2JsonView;
            }
        };
        return jsonViewResolver;
    }

    @Bean
    public MyInterceptor createInterceptor() {
        return new MyInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(createInterceptor());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
    }

    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(-1);//100kb
        multipartResolver.setDefaultEncoding("UTF-8");
        return multipartResolver;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/see").setViewName("/see");
        registry.addViewController("/async").setViewName("/async");
    }

}
