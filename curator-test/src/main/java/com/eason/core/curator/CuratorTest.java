package com.eason.core.curator;

import com.eason.core.curator.Utils.CuratorUtils;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryOneTime;

/**
 * Created by feng yingsheng on 2/20/2017.
 */
public class CuratorTest {

    public static void main(String[] args) throws Exception {
//        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
//        CuratorFramework cf = CuratorFrameworkFactory.newClient("123.207.141.51:2181", 5000, 3000, retryPolicy);
//        cf.start();
//        System.out.println(cf);

        CuratorFramework client = CuratorUtils.start();
        System.out.println(client);
        Object res = client.create().forPath("test");
        System.out.println(res);

    }
}
