package com.imiku.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imiku.blog.BlogVo;
import com.imiku.blog.dao.NoticeInfoDao;
import com.imiku.blog.model.NoticeInfo;
import com.imiku.blog.service.NoticeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Lenovo on 2017/4/19.
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Resource
    private NoticeInfoDao noticeInfoDao;

    @Override
    public PageInfo<NoticeInfo> findAllNotice(BlogVo blogVo) {
        if(StringUtils.isBlank(blogVo.getBlogName())){
            blogVo.setBlogName(null);
        }
        PageHelper.startPage(blogVo.getPageNum(), 8);
        List<NoticeInfo> list = noticeInfoDao.findAllNotice();
        PageInfo<NoticeInfo> page = new PageInfo(list, 8);
        return page;
    }

    @Override
    public void add(BlogVo blogVo) {
        NoticeInfo noticeInfo = new NoticeInfo();
        noticeInfo.setNoticeContext(blogVo.getContext());
        noticeInfo.setLevel(blogVo.getLevel());
        noticeInfo.setCreateDate(blogVo.getCreateDate());
        noticeInfoDao.insert(noticeInfo);
    }

    @Override
    public void update(BlogVo blogVo) {
        NoticeInfo noticeInfo = noticeInfoDao.selectByPrimaryKey(blogVo.getBlogId());
        noticeInfo.setNoticeContext(blogVo.getContext());
        noticeInfo.setLevel(blogVo.getLevel());
        noticeInfo.setCreateDate(blogVo.getCreateDate());
        noticeInfoDao.updateByPrimaryKeySelective(noticeInfo);
    }

    @Override
    public void delete(BlogVo blogVo) {
        noticeInfoDao.deleteByPrimaryKey(blogVo.getBlogId());
    }
}
