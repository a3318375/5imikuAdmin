package com.imiku.blog.dao;

import com.imiku.blog.dao.base.BaseDao;
import com.imiku.blog.model.UserInfo;

import java.util.List;

public interface UserInfoDao extends BaseDao<UserInfo> {

    UserInfo getByAccountName(String username);

    List<UserInfo> findByNames(String username);

    List<UserInfo> list(String userName, Integer roleId);
}