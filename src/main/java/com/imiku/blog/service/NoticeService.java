package com.imiku.blog.service;

import com.github.pagehelper.PageInfo;
import com.imiku.blog.BlogVo;
import com.imiku.blog.model.NoticeInfo;

/**
 * Created by Lenovo on 2017/4/19.
 */
public interface NoticeService {

    PageInfo<NoticeInfo> findAllNotice(BlogVo blogVo);

    void add(BlogVo blogVo);

    void update(BlogVo blogVo);

    void delete(BlogVo blogVo);
}
