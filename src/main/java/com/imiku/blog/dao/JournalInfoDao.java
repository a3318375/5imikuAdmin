package com.imiku.blog.dao;

import com.imiku.blog.dao.base.BaseDao;
import com.imiku.blog.model.JournalInfo;

import java.util.List;

public interface JournalInfoDao extends BaseDao<JournalInfo> {

    List<JournalInfo> findAllJournal();
}