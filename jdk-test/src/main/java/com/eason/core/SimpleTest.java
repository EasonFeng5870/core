package com.eason.core;

import java.io.File;

/**
 * Created by fengyingsheng on 2017-9-26.
 */
public class SimpleTest {

    public static void main(String[] args) {
        String path = "/usr/local/tomcat/webapps/shopping/upload/store/32777/2017/09/26/5e7fbe71-40bb-4985-927b-7ca0e50bfe8b.jpg";
        String[] subPath = path.split("upload");
        System.out.println(subPath[0]);
        System.out.println("upload" + subPath[1] );
        File file = new File("http://img61.ddimg.cn/upload_img/00555/msg/msgtemplate5.png");
        System.out.println(file.canRead());
    }
}
