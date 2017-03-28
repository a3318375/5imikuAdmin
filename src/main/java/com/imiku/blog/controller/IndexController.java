package com.imiku.blog.controller;

import com.imiku.blog.utils.ErrorMaps;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Lenovo on 2017/3/28.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("index")
    public String index() throws Exception {
        return "index";
    }

    @RequestMapping(value = "login", produces = "text/html; charset=utf-8")
    public String login(String username, String password, HttpServletRequest request) {
        // try {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            request.setAttribute("errorMsg", ErrorMaps.NAME_NULL_MESSAGE);
            return "login";
        }
        Subject user = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            user.login(token);
        } catch (LockedAccountException lae) {
            token.clear();
            request.setAttribute("errorMsg", ErrorMaps.USER_LOCK_MESSAGE);
            return "login";

        } catch (ExcessiveAttemptsException e) {
            token.clear();
            request.setAttribute("errorMsg", ErrorMaps.ERROR_TOMORE_MESSAGE);
            return "login";
        } catch (AuthenticationException e) {
            token.clear();
            request.setAttribute("errorMsg", ErrorMaps.NAME_ERROR_MESSAGE);
            return "login";
        }
        return "redirect:index";
    }

}
