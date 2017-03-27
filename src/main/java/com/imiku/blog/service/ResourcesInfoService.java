package com.imiku.blog.service;

import com.imiku.blog.model.ResourcesInfo;
import com.imiku.blog.model.RoleInfo;

import java.util.List;

/**
 * Created by yuxh on 2017/3/28.
 */
public interface ResourcesInfoService {

    List<ResourcesInfo> findAllResources();

    List<ResourcesInfo> findRoleResourcess(List<RoleInfo> rolelist);
}
