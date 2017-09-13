package com.eason.core.classloader;

import sun.misc.Launcher;

import java.net.URL;

/**
 * Created by fengyingsheng on 2017-9-11.
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        Launcher launcher;
//        System.out.println(System.getProperty("sun.boot.class.path"));
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL url: urls) {
            System.out.println(url.toExternalForm());
        }
    }

}
