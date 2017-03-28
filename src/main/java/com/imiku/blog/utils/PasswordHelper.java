package com.imiku.blog.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class PasswordHelper {
	private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
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
		map.put("password", "123456");
//		String salt=randomNumberGenerator.nextBytes().toHex();
		String salt="fd3ad6ff0059013b58d2d81d026b94dc";
		map.put("credentialsSalt", salt);
		String newPassword = new SimpleHash(algorithmName, map.get("password"), ByteSource.Util.bytes(map.get("accountName")+salt), hashIterations).toHex();
		map.put("password", newPassword); 
		System.out.println(map.toString());
	}
}
