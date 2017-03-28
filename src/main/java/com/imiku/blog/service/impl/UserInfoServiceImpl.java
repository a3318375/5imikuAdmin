package com.imiku.blog.service.impl;

import com.imiku.blog.dao.UserInfoDao;
import com.imiku.blog.model.UserInfo;
import com.imiku.blog.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yuxh on 2017/3/28.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public List<UserInfo> findByNames(String username) {
        return userInfoDao.findByNames(username);
    }

    @Override
    public UserInfo getByAccountName(String username) {
        return userInfoDao.getByAccountName(username);
    }
}
