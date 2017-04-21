package com.imiku.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imiku.blog.dao.UserInfoDao;
import com.imiku.blog.model.UserInfo;
import com.imiku.blog.model.UserRole;
import com.imiku.blog.service.UserInfoService;
import com.imiku.blog.utils.PasswordHelper;
import com.imiku.blog.vo.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Override
    public PageInfo<UserInfo> list(UserVo userVo) {
        if(StringUtils.isBlank(userVo.getUserName())){
            userVo.setUserName(null);
        }
        PageHelper.startPage(userVo.getPageNum(), 8);
        List<UserInfo> list = userInfoDao.list(userVo.getUserName(),userVo.getRoleId());
        PageInfo<UserInfo> page = new PageInfo<>(list, 8);
        return page;
    }

    @Override
    public void addUser(UserVo userVo) {
        UserInfo userInfo = new UserInfo();
        userInfo.setLocked("0");
        userInfo.setCreateDate(new Date());
        userInfo.setAccountName(userVo.getAccount());
        userInfo.setDeleteStatus(0);
        userInfo.setDescription("test");
        userInfo.setPassword(userVo.getPassword());
        userInfo.setCredentialsSalt("");
        userInfo.setUserName(userVo.getUserName());

        PasswordHelper.encryptPassword(userInfo);
        userInfoDao.insert(userInfo);
    }

    @Override
    public void updateLock(UserVo userVo) {
        UserInfo userInfo = userInfoDao.selectByPrimaryKey(userVo.getUserId());
        userInfo.setLocked(userVo.getLock());
        userInfoDao.updateByPrimaryKey(userInfo);
    }
}
