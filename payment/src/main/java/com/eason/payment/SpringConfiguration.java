package com.eason.payment;

import com.eason.payment.aware.AwareService;
import com.eason.payment.threadpool.AsyncTaskService;
import com.eason.payment.threadpool.TaskExecutorConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by feng yingsheng on 9/30/2017.
 */
@Configuration
@ComponentScan(basePackages = "com.eason.payment")
@PropertySource(ignoreResourceNotFound=false, value = "classpath:env.properties")
@EnableWebMvc
public class SpringConfiguration {

    public static void main(String[] args) {
        annotionMain();
    }

    public static void annotionMain() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class, TaskExecutorConfig.class);
        SpringComponent springComponent = (SpringComponent)applicationContext.getBean("springComponent");
        springComponent.test();
        SpringComponent2 springComponent2 = applicationContext.getBean(SpringComponent2.class);
        springComponent2.test();
        AwareService awareService = applicationContext.getBean(AwareService.class);
        awareService.outPutResult();

        AsyncTaskService asyncTaskService = applicationContext.getBean(AsyncTaskService.class);
        for (int i=0; i<10; i++) {
            asyncTaskService.executeAsyncTask(i);
            asyncTaskService.executeAsyncTaskPlus(i);
        }

        applicationContext.close();
    }

//    @Bean()
//    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//        return new PropertySourcesPlaceholderConfigurer();
//    }
}
