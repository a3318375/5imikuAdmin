package com.imiku.blog.dao.base;

/**
 * Created by Lenovo on 2017/3/30.
 */
public interface BaseDao<T> {

    int deleteByPrimaryKey(Integer id);

    int insert(T t);

    int insertSelective(T t);

    T selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);
}
