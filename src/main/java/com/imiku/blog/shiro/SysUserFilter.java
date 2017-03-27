package com.imiku.blog.shiro;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.imiku.blog.model.UserInfo;
import com.imiku.blog.service.UserInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;


public class SysUserFilter extends PathMatchingFilter {

	@Autowired
	private UserInfoService userInfoService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        String username = (String)SecurityUtils.getSubject().getPrincipal();
		List<UserInfo> list = userInfoService.findByNames(username);
        request.setAttribute("user", list);
        return true;
    }
}