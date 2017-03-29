package com.imiku.blog.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yuxh on 2017/3/21.
 */
public class DateUtils {

    public static String get8Date() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(new Date());
    }

    public static String get14Date(Date createDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(createDate);
    }
}
