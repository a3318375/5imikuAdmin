package com.imiku.blog.service;

import com.github.pagehelper.PageInfo;
import com.imiku.blog.model.UserInfo;
import com.imiku.blog.vo.UserVo;

import java.util.List;

/**
 * Created by yuxh on 2017/3/28.
 */
public interface UserInfoService {

    List<UserInfo> findByNames(String username);

    UserInfo getByAccountName(String username);

    PageInfo<UserInfo> list(UserVo userVo);

    void addUser(UserVo userVo);

    void updateLock(UserVo userVo);
}
