package com.imiku.blog.service;

import com.imiku.blog.model.UserInfo;

import java.util.List;

/**
 * Created by yuxh on 2017/3/28.
 */
public interface UserInfoService {
    List<UserInfo> findByNames(String username);
}
