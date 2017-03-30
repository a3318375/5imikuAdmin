package com.imiku.blog.service.impl;

import com.imiku.blog.dao.RoleInfoDao;
import com.imiku.blog.model.RoleInfo;
import com.imiku.blog.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yuxh on 2017/3/28.
 */
@Service
public class RoleInfoServiceImpl implements RoleInfoService {

    @Autowired
    private RoleInfoDao roleInfoDao;

    @Override
    public List<RoleInfo> findRoleByUserId(int userId) {
        return roleInfoDao.findRoleByUserId(userId);
    }

    @Override
    public List<RoleInfo> findAllRoles() {
        return null;
    }
}
