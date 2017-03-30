package com.imiku.blog.dao;

import com.imiku.blog.dao.base.BaseDao;
import com.imiku.blog.model.ResourcesInfo;
import com.imiku.blog.model.RoleInfo;

import java.util.List;

public interface ResourcesInfoDao extends BaseDao<ResourcesInfo> {

    List<ResourcesInfo> findAllResources();

    List<ResourcesInfo> findRoleResourcess(List<RoleInfo> rolelist);
}