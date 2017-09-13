package com.eason.core.spring;

import com.eason.core.spring.bean.EmployeeDTO;
import com.eason.core.spring.factory.EmployeeFactoryBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by feng yingsheng on 3/7/2017.
 */
public class SpringTest {

    public static void main(String[] args) throws Exception {
        BeanFactory beanFactory;
        ClassPathXmlApplicationContext applicationContext;

        ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("spring-applicationContext.xml");
        EmployeeDTO manager = (EmployeeDTO) applicationContext1.getBean("manager");
        System.out.println(manager);
        EmployeeDTO manager2 = (EmployeeDTO) applicationContext1.getBean("manager");
        System.out.println(manager2);
//        EmployeeDTO director = (EmployeeDTO) applicationContext1.getBean("director");
//        System.out.println(director);

//        EmployeeFactoryBean managerFactoryBean = (EmployeeFactoryBean) applicationContext1.getBean("&manager");
//        System.out.println(managerFactoryBean);
//        System.out.println(managerFactoryBean.getDesignation());
//        System.out.println(managerFactoryBean.getObjectType());
//        System.out.println(managerFactoryBean.getObject());
    }
}
