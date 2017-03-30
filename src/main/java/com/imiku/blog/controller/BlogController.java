package com.imiku.blog.controller;

import com.github.pagehelper.PageInfo;
import com.imiku.blog.BlogVo;
import com.imiku.blog.model.BlogInfo;
import com.imiku.blog.model.TypeInfo;
import com.imiku.blog.service.BlogInfoService;
import com.imiku.blog.service.TypeInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Lenovo on 2017/3/29.
 */
@Controller
@RequestMapping("/blog")
public class BlogController {

    @Resource
    private BlogInfoService blogInfoService;
    @Resource
    private TypeInfoService typeInfoService;

    @RequestMapping("/list")
    public String list(BlogVo blogVo, Model model) throws Exception {
        List<TypeInfo> tlist = typeInfoService.findAllTypes();
        PageInfo<BlogInfo> page = blogInfoService.list(blogVo);
        model.addAttribute("blogVo",blogVo);
        model.addAttribute("page",page);
        model.addAttribute("tlist",tlist);
        return "blog";
    }

    @RequestMapping("/addBlog")
    public String addBlog(BlogVo blogVo, Model model) throws Exception {
        List<TypeInfo> tlist = typeInfoService.findAllTypes();
        model.addAttribute("tlist",tlist);
        return "addBlog";
    }

    @RequestMapping("/saveBlog")
    public String saveBlog(BlogVo blogVo, Model model) throws Exception {
        blogInfoService.saveBlog(blogVo);
        return "redirect:/blog/list?pageNum=1";
    }

    @RequestMapping("/updateTop")
    @ResponseBody
    public boolean updateTop(BlogVo blogVo) throws Exception {
        blogInfoService.updateTop(blogVo);
        return true;
    }

    @RequestMapping("/updateRecommend")
    @ResponseBody
    public boolean updateRecommend(BlogVo blogVo) throws Exception {
        blogInfoService.updateRecommend(blogVo);
        return true;
    }
}
