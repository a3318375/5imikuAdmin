package com.imiku.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imiku.blog.BlogVo;
import com.imiku.blog.dao.BlogInfoDao;
import com.imiku.blog.model.BlogInfo;
import com.imiku.blog.service.BlogInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Lenovo on 2017/3/29.
 */
@Service
public class BlogInfoServiceImpl implements BlogInfoService {

    @Resource
    private BlogInfoDao blogInfoDao;

    @Override
    public PageInfo<BlogInfo> list(BlogVo blogVo) {
        PageHelper.startPage(blogVo.getPageNum(), 8);
        List<BlogInfo> list = blogInfoDao.list();
        PageInfo<BlogInfo> page = new PageInfo<>(list, 8);
        return page;
    }

}
