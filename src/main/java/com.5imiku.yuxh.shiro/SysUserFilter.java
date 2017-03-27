package com.itruschina.ras.shiro.filter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import com.itruschina.ras.service.UserService;
import com.itruschina.ras.vo.User;


public class SysUserFilter extends PathMatchingFilter {

	@Autowired
	private UserService userService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        String username = (String)SecurityUtils.getSubject().getPrincipal();
        Map<String,Object> map = new HashMap<>();
		map.put("accountName", username);
		List<User> list = userService.findByNames(map);
        request.setAttribute("user", list);
        return true;
    }
}