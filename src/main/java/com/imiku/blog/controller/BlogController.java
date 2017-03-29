package com.imiku.blog.controller;

import com.github.pagehelper.PageInfo;
import com.imiku.blog.BlogVo;
import com.imiku.blog.model.BlogInfo;
import com.imiku.blog.service.BlogInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by Lenovo on 2017/3/29.
 */
@Controller
@RequestMapping("/blog")
public class BlogController {

    @Resource
    private BlogInfoService blogInfoService;

    @RequestMapping("/list")
    public String index(BlogVo blogVo, Model model) throws Exception {
        PageInfo<BlogInfo> page = blogInfoService.list(blogVo);
        model.addAttribute("page",page);
        return "blog";
    }

}
