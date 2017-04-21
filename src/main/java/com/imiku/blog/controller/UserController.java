package com.imiku.blog.controller;

import com.github.pagehelper.PageInfo;
import com.imiku.blog.BlogVo;
import com.imiku.blog.model.RoleInfo;
import com.imiku.blog.model.UserInfo;
import com.imiku.blog.service.RoleInfoService;
import com.imiku.blog.service.UserInfoService;
import com.imiku.blog.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yuxh on 2017/3/30.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserInfoService userInfoService;
    @Resource
    private RoleInfoService roleInfoService;

    @RequestMapping("/list")
    public String list(UserVo userVo, Model model) throws Exception {
        List<RoleInfo> rlist = roleInfoService.findAllRoles();
        PageInfo<UserInfo> page = userInfoService.list(userVo);
        model.addAttribute("userVo",userVo);
        model.addAttribute("page",page);
        model.addAttribute("rlist",rlist);
        return "user_list";
    }

    @RequestMapping("/toAddUser")
    public String toAddUser(Model model) throws Exception {
        List<RoleInfo> rlist = roleInfoService.findAllRoles();
        model.addAttribute("rlist",rlist);
        return "user_add";
    }

    @RequestMapping("/add")
    public String addUser(UserVo userVo) throws Exception {
        userInfoService.addUser(userVo);
        return "redirect:/user/list?pageNum=1";
    }


    @RequestMapping("/updateLock")
    @ResponseBody
    public boolean updateLock(UserVo userVo) throws Exception {
        userInfoService.updateLock(userVo);
        return true;
    }
}
