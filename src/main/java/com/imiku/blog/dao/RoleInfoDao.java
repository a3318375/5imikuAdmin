package com.imiku.blog.dao;

import com.imiku.blog.dao.base.BaseDao;
import com.imiku.blog.model.RoleInfo;

import java.util.List;

public interface RoleInfoDao extends BaseDao<RoleInfo> {

    List<RoleInfo> findRoleByUserId(int userId);
}