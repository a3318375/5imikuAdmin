package com.imiku.blog.dao;

import com.imiku.blog.model.ResourcesInfo;
import com.imiku.blog.model.RoleInfo;

import java.util.List;

public interface ResourcesInfoDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resources_info
     *
     * @mbggenerated Tue Mar 28 00:19:28 CST 2017
     */
    int deleteByPrimaryKey(Integer resourcesId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resources_info
     *
     * @mbggenerated Tue Mar 28 00:19:28 CST 2017
     */
    int insert(ResourcesInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resources_info
     *
     * @mbggenerated Tue Mar 28 00:19:28 CST 2017
     */
    int insertSelective(ResourcesInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resources_info
     *
     * @mbggenerated Tue Mar 28 00:19:28 CST 2017
     */
    ResourcesInfo selectByPrimaryKey(Integer resourcesId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resources_info
     *
     * @mbggenerated Tue Mar 28 00:19:28 CST 2017
     */
    int updateByPrimaryKeySelective(ResourcesInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resources_info
     *
     * @mbggenerated Tue Mar 28 00:19:28 CST 2017
     */
    int updateByPrimaryKey(ResourcesInfo record);

    List<ResourcesInfo> findAllResources();

    List<ResourcesInfo> findRoleResourcess(List<RoleInfo> rolelist);
}