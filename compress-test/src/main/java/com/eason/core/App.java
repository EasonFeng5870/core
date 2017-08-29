package com.eason.core;

import com.eason.core.utils.compress.CompressUtils;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;

import java.io.File;
import java.io.FileInputStream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        File file = new File("D:\\test\\a\\a.zip");
//        System.out.println(file.isDirectory());
//        unCompress(file);
    }

    private static void unCompress(File file) throws Exception {
        if(file.isDirectory()) {
            File[] files = file.listFiles();
            int fileLength = files.length;
            for(int i=0; i<fileLength; i++) {
                File subFile = files[i];
                if(subFile.isDirectory()) {
                    unCompress(subFile);
                }
                else {
                    String res = CompressUtils.isCompressFile(subFile);
                    if("rar".equalsIgnoreCase(res)) {
                        System.out.println(subFile.getAbsolutePath());

                    }
                    else if("zip".equalsIgnoreCase(res)) {
                        System.out.println(subFile.getAbsolutePath());
                        FileInputStream fileInputStream = new FileInputStream(subFile);

                        ZipArchiveEntry entry = new ZipArchiveEntry(subFile.getAbsolutePath());

                    }
                    else {
                        System.out.println("not a compress file ,do nothing.");
                    }
                }
            }
        }
        else {
            System.out.println(CompressUtils.isCompressFile(file));
        }
    }
}
