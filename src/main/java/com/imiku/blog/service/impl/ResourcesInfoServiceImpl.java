package com.imiku.blog.service.impl;

import com.imiku.blog.dao.ResourcesInfoDao;
import com.imiku.blog.model.ResourcesInfo;
import com.imiku.blog.model.RoleInfo;
import com.imiku.blog.service.ResourcesInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yuxh on 2017/3/28.
 */
@Service
public class ResourcesInfoServiceImpl implements ResourcesInfoService {

    @Autowired
    private ResourcesInfoDao resourcesInfoDao;

    @Override
    public List<ResourcesInfo> findAllResources() {
        return resourcesInfoDao.findAllResources();
    }

    @Override
    public List<ResourcesInfo> findRoleResourcess(List<RoleInfo> rolelist) {
        return resourcesInfoDao.findRoleResourcess(rolelist);
    }
}
