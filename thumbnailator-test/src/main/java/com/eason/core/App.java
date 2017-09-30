package com.eason.core;

import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
//        URL url = new URL("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png");
//        Thumbnails.of(url).size(50, 50).toFile("d://mm.png");
//        BufferedImage bufferedImage = Thumbnails.of(url).size(50, 50).asBufferedImage();
//        ByteArrayInputStream byteArrayInputStream = getImageStream(bufferedImage);
        File file = new File("e://m/iphone_cust_id_2017-09-27-14.txt");
        Set<String> xiaoMi = readFile(file);
        Set<String> origin = readFile(new File("e://m/split_bug8091_default_cust_id_num545268.txt"));
        Set<String> s3 = new HashSet<String>();
        Set<String> last = new HashSet<String>(origin.size());
        for (String custId : origin) {
            if(xiaoMi.contains(custId)) {
                last.add(custId);
            }
        }
        System.out.println(last.size());
        writeFile(last, "e://m/iphone.txt");
        //List<String> last = setHandle(origin, xiaoMi, s3,3);
        //System.out.println(last.size());
    }

    private static void writeFile(Set<String> allNewCustIds, String todaySentFilePath) {
        long start = System.currentTimeMillis();
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try{
            final boolean isPendingToFile = true;
            fileWriter = new FileWriter(todaySentFilePath, isPendingToFile);
            bufferedWriter = new BufferedWriter(fileWriter);
            int i = 0;
            bufferedWriter.newLine();
            for(String custIds : allNewCustIds) {
                i++;
                bufferedWriter.write(custIds);
                bufferedWriter.newLine();
                if(i % 1000 == 0) {
                    bufferedWriter.flush();
                }
            }
            bufferedWriter.flush();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<String> setHandle(Set<String> s1, Set<String> s2, Set<String> s3, int retryTimes) {
        long start = System.currentTimeMillis();
        List<String> list = null;
        try{
            Set<String> result = new HashSet<String>(s2.size());
            if(s2.size() < s1.size()) {
                result.addAll(s2);//s2量少
                result.retainAll(s1);//S1集合和S2集合取交集
            }
            else {
                result.addAll(s1);//s1量少
                result.retainAll(s2);//S1集合和S2集合取交集
            }
            result.removeAll(s3);//再和S3取差集  即可得到未发送用户
            list = new ArrayList<String>(result.size());
            list.addAll(result);
        }
        catch (Exception e) {
            e.printStackTrace();
            if(retryTimes > 0) {
                retryTimes--;
                setHandle(s1, s2, s3, retryTimes);
            }
            list = new ArrayList<String>();
        }
        return list;
    }

    private static Set<String> readFile(File file) {
        Set<String> set = new HashSet<String>();
        BufferedReader reader = null;
        InputStreamReader inputStreamReader = null;
        FileInputStream fileInputStream = null;
        try {
            // 取文件夹下的第一个文件流
            fileInputStream = new FileInputStream(file);
            inputStreamReader = new InputStreamReader(fileInputStream);
            reader = new BufferedReader(inputStreamReader);

            // 读取文件中的每行
            String line = reader.readLine();
            while (line != null) {
                String cust = line.trim();
                // 将custids放在set集合中，去重
                if (cust != null && !"".equals(cust)) {
                    set.add(cust);
                }
                line = reader.readLine();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return set;
    }

}
