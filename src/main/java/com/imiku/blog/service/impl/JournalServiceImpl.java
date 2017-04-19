package com.imiku.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imiku.blog.BlogVo;
import com.imiku.blog.dao.JournalInfoDao;
import com.imiku.blog.model.JournalInfo;
import com.imiku.blog.model.NoticeInfo;
import com.imiku.blog.service.JournalService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by Lenovo on 2017/4/19.
 */
@Service
public class JournalServiceImpl implements JournalService {

    @Resource
    private JournalInfoDao journalInfoDao;

    @Override
    public PageInfo<JournalInfo> findAllJournal(BlogVo blogVo) {
        if(StringUtils.isBlank(blogVo.getBlogName())){
            blogVo.setBlogName(null);
        }
        PageHelper.startPage(blogVo.getPageNum(), 8);
        List<JournalInfo> list = journalInfoDao.findAllJournal();
        PageInfo<JournalInfo> page = new PageInfo(list, 8);
        return page;
    }

    @Override
    public void add(BlogVo blogVo) {
        JournalInfo journalInfo = new JournalInfo();
        journalInfo.setJournalContext(blogVo.getContext());
        journalInfo.setCreateDate(new Date());
        journalInfoDao.insert(journalInfo);
    }

    @Override
    public void update(BlogVo blogVo) {
        JournalInfo journalInfo = journalInfoDao.selectByPrimaryKey(blogVo.getBlogId());
        journalInfo.setJournalContext(blogVo.getContext());
        journalInfoDao.updateByPrimaryKeySelective(journalInfo);
    }

    @Override
    public void delete(BlogVo blogVo) {
        journalInfoDao.deleteByPrimaryKey(blogVo.getBlogId());
    }
}
