package com.imiku.blog.service;

import com.github.pagehelper.PageInfo;
import com.imiku.blog.BlogVo;
import com.imiku.blog.model.BlogInfo;

/**
 * Created by Lenovo on 2017/3/29.
 */
public interface BlogInfoService {

    PageInfo<BlogInfo> list(BlogVo blogVo);

    void saveBlog(BlogVo blogVo);

    void updateRecommend(BlogVo blogVo);

    void updateTop(BlogVo blogVo);

    BlogVo toUpdateBlog(BlogVo blogVo);

    void updateBlog(BlogVo blogVo);
}
