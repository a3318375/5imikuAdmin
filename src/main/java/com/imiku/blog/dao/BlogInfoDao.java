package com.imiku.blog.dao;

import com.imiku.blog.dao.base.BaseDao;
import com.imiku.blog.model.BlogInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogInfoDao extends BaseDao<BlogInfo> {

    List<BlogInfo> list(@Param("blogTitle")String blogName, @Param("typeId") Integer blogType);

}