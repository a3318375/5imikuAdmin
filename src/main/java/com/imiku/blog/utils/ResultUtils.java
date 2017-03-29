package com.imiku.blog.utils;


import com.alibaba.fastjson.JSONObject;

/**
 * Created by yuxh on 2017/3/21.
 */
public class ResultUtils {

    public static String getUploadResult(String name,String message) {
        JSONObject jsonObject = new JSONObject(true);
        jsonObject.put("code",0);
        jsonObject.put("msg",message);
        jsonObject.put("url", name);
        return jsonObject.toJSONString();
    }

}
