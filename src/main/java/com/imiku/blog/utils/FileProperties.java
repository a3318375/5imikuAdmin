package com.imiku.blog.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by yuxh on 2017/4/15.
 */
public class FileProperties {

    public static String htmlPath = "";
    public static String imgPath = "";
    public static String coverPath = "";

    static{
        Properties pro = new Properties();
        String filePath = FileProperties.class.getClassLoader().getResource("/properties/file.properties").getPath();
        FileInputStream in = null;
        try {
            in = new FileInputStream(filePath);
            pro.load(in);

            htmlPath = pro.getProperty("htmlPath");
            imgPath = pro.getProperty("imgPath");
            coverPath = pro.getProperty("coverPath");

            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
