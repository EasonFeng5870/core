package com.eason.core.utils.compress;

import java.io.File;

/**
 * Created by feng yingsheng on 7/17/2017.
 */
public class CompressUtils {

    public static String isCompressFile(File file) {

        if(file.isDirectory()) {
            return "";
        }
        else {
            String fileName = file.getName();
            if(fileName.endsWith("zip") || fileName.endsWith("ZIP")) {
                return "zip";
            }
            if(fileName.endsWith("rar") || fileName.endsWith("RAR")) {
                return "rar";
            }
        }
        return "";
    }
}
