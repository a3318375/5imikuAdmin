package com.imiku.blog.utils;

import java.util.Calendar;

/**
 * Created by Lenovo on 2017/3/23.
 */
public class Toolkits {

    public static String getPath(){
        Calendar now = Calendar.getInstance();
        String path = now.get(Calendar.YEAR) + "/" + (now.get(Calendar.MONTH) + 1) + "/" +  now.get(Calendar.DAY_OF_MONTH) + "/";
        return path;
    }
}
