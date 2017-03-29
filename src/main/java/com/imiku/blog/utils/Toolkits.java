package com.imiku.blog.utils;

/**
 * Created by Lenovo on 2017/3/23.
 */
public class Toolkits {

    public static String getPath(){
        String path = UUIDUtils.class.getResource("/").getPath();
        path = path.substring(0,path.indexOf("WEB-INF"));
        //path = path + "libs/exploded/5imiku-1.0-SNAPSHOT.war/upload/";
        path = path + "upload/";
        return path;
    }
}
