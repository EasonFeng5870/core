package com.eason.payment.aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

/**
 * Created by feng yingsheng on 10/1/2017.
 */
@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {

    private String beanName;

    private ResourceLoader resourceLoader;

    public void setBeanName(String s) {
        System.out.println(s);
        this.beanName = s;
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public void outPutResult() {
        System.out.println("bean name :" + this.beanName);
        Resource resource = resourceLoader.getResource("classpath:env.properties");
        try{
            System.out.println("ResourceLoader 加载的文件内容为：" + IOUtils.toString(resource.getInputStream()));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
