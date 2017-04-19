package com.imiku.blog.dao;

import com.imiku.blog.dao.base.BaseDao;
import com.imiku.blog.model.NoticeInfo;

import java.util.List;

public interface NoticeInfoDao extends BaseDao<NoticeInfo> {

    List<NoticeInfo> findAllNotice();
}