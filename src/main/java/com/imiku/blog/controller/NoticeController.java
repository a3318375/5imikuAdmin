package com.imiku.blog.controller;

import com.github.pagehelper.PageInfo;
import com.imiku.blog.BlogVo;
import com.imiku.blog.model.NoticeInfo;
import com.imiku.blog.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Lenovo on 2017/4/18.
 */
@Controller
@RequestMapping("/notice")
public class NoticeController {


    @Resource
    private NoticeService noticeService;

    @RequestMapping("/list")
    public String list(BlogVo blogVo,Model model){
        PageInfo<NoticeInfo> page = noticeService.findAllNotice(blogVo);
        model.addAttribute("page",page);
        return "notice_list";
    }

    @RequestMapping("/add")
    public String add(BlogVo blogVo){
        noticeService.add(blogVo);
        return "redirect:/notice/list?pageNum=1";
    }


    @RequestMapping("/update")
    public String update(BlogVo blogVo){
        noticeService.update(blogVo);
        return "redirect:/notice/list?pageNum=1";
    }

    @RequestMapping("/delete")
    public String delete(BlogVo blogVo){
        noticeService.delete(blogVo);
        return "redirect:/notice/list?pageNum=1";
    }
}
