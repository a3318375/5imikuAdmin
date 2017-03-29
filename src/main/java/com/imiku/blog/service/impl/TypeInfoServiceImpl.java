package com.imiku.blog.service.impl;

import com.imiku.blog.dao.TypeInfoDao;
import com.imiku.blog.model.TypeInfo;
import com.imiku.blog.service.TypeInfoService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Lenovo on 2017/3/21.
 */
@Service
public class TypeInfoServiceImpl implements TypeInfoService {

    @Resource
    private TypeInfoDao TypeInfoDao;

    @Override
    public List<TypeInfo> findAllTypes() {
        return TypeInfoDao.findAllTypes();
    }
}
