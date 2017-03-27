package com.itruschina.ras.shiro.filter;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.config.Ini;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.itruschina.ras.service.ResourcesService;
import com.itruschina.ras.vo.Resources;

/**
 * 产生责任链，确定每个url的访问权限
 * 
 */
@SuppressWarnings("rawtypes")
public class ChainDefinitionSectionMetaSource implements FactoryBean {

	@Autowired
	private ResourcesService resourcesService;

	// 静态资源访问权限
	private String filterChainDefinitions = null;

	public Ini.Section getObject() throws Exception {
//		new ConfigUtils().initTableField(resourcesMapper); 
		Ini ini = new Ini();
		// 加载默认的url
		ini.load(filterChainDefinitions);
		Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
		// 循环Resource的url,逐个添加到section中。section就是filterChainDefinitionMap,
		// 里面的键就是链接URL,值就是存在什么条件才能访问该链接
		List<Resources> lists = resourcesService.findAllResources();
		for (Resources resources : lists) {
			// 构成permission字符串
			if (StringUtils.isNotEmpty(resources.getResUri() + "") && StringUtils.isNotEmpty(resources.getResKey() + "")) {
				String permission = "perms[" + resources.getResKey() + "]";
				// 不对角色进行权限验证
//				 如需要则 permission = "roles[" + resources.getResKey() + "]";
//				String permission = "roles[" + resources.getResKey() + "]";
				System.out.println(permission);
				section.put(resources.getResUri() + "/**", permission);
			}

		}
		// 所有资源的访问权限，必须放在最后
		/*section.put("/**", "authc");*/
		/** 如果需要一个用户只能登录一处地方,,修改为 section.put("/**", "authc,kickout,sysUser,user"); **/
		section.put("/**", "authc,kickout,sysUser,user");
		return section;
	}

	/**
	 * 通过filterChainDefinitions对默认的url过滤定义
	 * 
	 * @param filterChainDefinitions
	 *            默认的url过滤定义
	 */
	public void setFilterChainDefinitions(String filterChainDefinitions) {
		this.filterChainDefinitions = filterChainDefinitions;
	}

	public Class<?> getObjectType() {
		return this.getClass();
	}

	public boolean isSingleton() {
		return false;
	}
}
