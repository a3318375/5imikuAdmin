package com.imiku.blog.utils;

import java.util.HashMap;
import java.util.Map;

public class ErrorMaps {

	public static String NAME_NULL = "101";
	public static String NAME_NULL_MESSAGE = "用户名或密码不能为空！";
	
	public static String NAME_ERROR = "102";
	public static String NAME_ERROR_MESSAGE = "用户或密码不正确！";
	
	public static String CAPTCHA_NULL = "103";
	public static String CAPTCHA_NULL_MESSAGE = "验证码不能为空！";
	
	public static String CAPTCHA_ERROR = "104";
	public static String CAPTCHA_ERROR_MESSAGE = "验证码不正确！";
	
	public static String USER_LOCK = "105";
	public static String USER_LOCK_MESSAGE = "用户已经被锁定不能登录，请与管理员联系！";
	
	public static String ERROR_TOMORE = "106";
	public static String ERROR_TOMORE_MESSAGE = "登录失败次数过多,锁定10分钟!";
	
	public static String ALL_STATUS = "101,102,103,104,105,106";

	public static String getMap(String status){
		Map<String,String> map = new HashMap<>();
		map.put(NAME_NULL, NAME_NULL_MESSAGE);
		map.put(NAME_ERROR, NAME_ERROR_MESSAGE);
		map.put(CAPTCHA_NULL, CAPTCHA_NULL_MESSAGE);
		map.put(CAPTCHA_ERROR, CAPTCHA_ERROR_MESSAGE);
		map.put(USER_LOCK, USER_LOCK_MESSAGE);
		map.put(ERROR_TOMORE, ERROR_TOMORE_MESSAGE);
		
		return map.get(status);
	}
	
}
