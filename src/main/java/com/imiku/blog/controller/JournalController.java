package com.imiku.blog.controller;

import com.github.pagehelper.PageInfo;
import com.imiku.blog.BlogVo;
import com.imiku.blog.model.JournalInfo;
import com.imiku.blog.service.JournalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by Lenovo on 2017/4/18.
 */
@Controller
@RequestMapping("/journal")
public class JournalController {

    @Resource
    private JournalService journalService;

    @RequestMapping("/list")
    public String list(BlogVo blogVo, Model model){
        PageInfo<JournalInfo> page = journalService.findAllJournal(blogVo);
        model.addAttribute("page",page);
        return "journal_list";
    }

    @RequestMapping("/add")
    public String add(BlogVo blogVo){
        journalService.add(blogVo);
        return "redirect:/journal/list?pageNum=1";
    }


    @RequestMapping("/update")
    public String update(BlogVo blogVo){
        journalService.update(blogVo);
        return "redirect:/journal/list?pageNum=1";
    }

    @RequestMapping("/delete")
    public String delete(BlogVo blogVo){
        journalService.delete(blogVo);
        return "redirect:/journal/list?pageNum=1";
    }
}
