package com.imiku.blog.controller;

import com.alibaba.fastjson.JSONObject;
import com.imiku.blog.utils.ErrorMaps;
import com.imiku.blog.utils.HttpClientUtils;
import com.imiku.blog.utils.PasswordHelper;
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
import java.util.HashMap;
import java.util.Map;

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
    public String login(String username, String password, String luotest_response,HttpServletRequest request) {
        // try {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)|| StringUtils.isEmpty(luotest_response)) {
            request.setAttribute("errorMsg", ErrorMaps.NAME_NULL_MESSAGE);
            return "login";
        }
        Map<String,String> map = new HashMap<>();
        map.put("api_key","8ac9908a797217b04732670e4429e82c");
        map.put("response",luotest_response);
        String str = HttpClientUtils.sendPost("https://captcha.luosimao.com/api/site_verify",map);
        JSONObject jsonObject = JSONObject.parseObject(str);
        String res = jsonObject.getString("res");
        if(!"success".equals(res)){
            request.setAttribute("errorMsg", ErrorMaps.CAPTCHA_ERROR_MESSAGE);
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
