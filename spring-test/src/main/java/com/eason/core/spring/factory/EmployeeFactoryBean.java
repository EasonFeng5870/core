package com.eason.core.spring.factory;

import com.eason.core.spring.bean.EmployeeDTO;
import org.springframework.beans.factory.config.AbstractFactoryBean;

/**
 * Created by fengyingsheng on 2017-9-6.
 */
public class EmployeeFactoryBean extends AbstractFactoryBean<Object> {

    private String designation;

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
}
