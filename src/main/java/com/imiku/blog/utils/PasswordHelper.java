package com.imiku.blog.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class PasswordHelper {
	private static SecureRandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	private static String algorithmName = "SHA-256";
	private static int hashIterations = 2;

	public static void encryptPassword(Map<String,Object> map) {
		String salt=randomNumberGenerator.nextBytes().toHex();
		map.put("credentialsSalt", salt);
		String newPassword = new SimpleHash(algorithmName, map.get("password"), ByteSource.Util.bytes(map.get("accountName")+salt), hashIterations).toHex();
		map.put("password", newPassword); 
	}
	
	public static String getPassword(String accountName,String password,String salt) {
		String newPassword = new SimpleHash(algorithmName, password , ByteSource.Util.bytes(accountName+salt), hashIterations).toHex();
		return newPassword;
	}
	
	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<>();
		map.put("accountName", "admin");
		map.put("password", "123");
		//String salt=randomNumberGenerator.nextBytes().toHex();
		String salt="4157c3feef4a6ed91b2c28cf4392f2d1";
		map.put("credentialsSalt", salt);
		String newPassword = new SimpleHash(algorithmName, map.get("password"), ByteSource.Util.bytes(map.get("accountName")+salt), hashIterations).toHex();
		map.put("password", newPassword);
		System.out.println(map.toString());
	}
}
