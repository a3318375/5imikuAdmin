package com.imiku.blog.dao;

import com.imiku.blog.dao.base.BaseDao;
import com.imiku.blog.model.TypeInfo;

import java.util.List;

public interface TypeInfoDao extends BaseDao<TypeInfo>{

    List<TypeInfo> findAllTypes();
}