package com.eason.core.spring.factory;

import com.eason.core.spring.bean.EmployeeDTO;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.util.ClassUtils;

/**
 * Created by fengyingsheng on 2017-9-6.
 */
public class EmployeeFactoryBean extends AbstractFactoryBean<Object> implements BeanClassLoaderAware , InitializingBean {

    private String designation;

    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Class<EmployeeDTO> getObjectType() {
        return EmployeeDTO.class;
    }

    protected Object createInstance() throws Exception {
        EmployeeDTO employee = new EmployeeDTO();
        employee.setId(-1);
        employee.setFirstName("eason");
        employee.setLastName("feng");
        employee.setDesignation(designation);
        return employee;
    }

    public void setBeanClassLoader(ClassLoader classLoader) {
        this.beanClassLoader = classLoader;
        System.out.println(this.beanClassLoader);
    }

    public void afterPropertiesSet() throws Exception {
        super.afterPropertiesSet();
        System.out.println("afterPropertiesSet ----- is called.");
    }
}
