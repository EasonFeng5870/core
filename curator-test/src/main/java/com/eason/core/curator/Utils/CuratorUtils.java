package com.eason.core.curator.Utils;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * Created by feng yingsheng on 2/27/2017.
 */
public class CuratorUtils {

    public static CuratorFramework start(){
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.builder().connectString("123.207.141.51:2181")
                .sessionTimeoutMs(5000).retryPolicy(retryPolicy)
                .namespace("base").build();
        client.start();
        return client;
    }
}
