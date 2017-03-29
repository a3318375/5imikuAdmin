package com.imiku.blog.utils;

import java.util.UUID;

public class UUIDUtils {

	/**
	* <p>方法名称: getUUID36</p>
	* <p>方法描述: 生成36位uuid，带-</p>
	* <p>作者: 于小皓</p>
	* <p>日期: 2016年7月14日</p>
	* @return
	* @throws
	 */
	public static String getUUID36(){
		UUID uuid = UUID.randomUUID();
        return uuid.toString();
	}
	
	/**
	* <p>方法名称: getUUID16</p>
	* <p>方法描述: 生成16位UUID，截取中间一段</p>
	* <p>作者: 于小皓</p>
	* <p>日期: 2016年7月14日</p>
	* @return
	* @throws
	 */
	public static String getUUID16(){
		UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-", "").substring(9, 25);
	}
	
	/**
	* <p>方法名称: getUUID16</p>
	* <p>方法描述: 根据uuid截取一部分</p>
	* <p>作者: 于小皓</p>
	* <p>日期: 2016年7月14日</p>
	* @param uuid
	* @return
	* @throws
	 */
	public static String getUUID16(String uuid){
        return uuid.replaceAll("-", "").substring(9, 25);
	}
	
	/**
	* <p>方法名称: getUUID32</p>
	* <p>方法描述: 生成32位UUID，无-</p>
	* <p>作者: 于小皓</p>
	* <p>日期: 2016年7月14日</p>
	* @return
	* @throws
	 */
	public static String getUUID32(){
		UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-", "");
	}
}
