package com.hill.mall.dao.common;

import com.github.pagehelper.PageInfo;
import com.hill.mall.dao.common.page.PageDataResult;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 基于实体的通用CRUD操作
 *
 * @Author huleilei9
 * @Date 2022/10/29
 **/
public interface CommonDBOperator<T> {

    int insert(T t);

    int delete(T t);

    int updateByPrimaryKey(T t);

    int updateByPrimaryKeySelective(T t);

    int updateByExample(T t, Example e);

    int updateByExampleSelective(T t, Example e);

    T selectOne(T t);

    List<T> select();

    List<T> select(T t);

    List<T> selectByExample(Example e);

    T selectByPrimaryKey(Long pk);

    PageInfo<T> selectPage(int pageNum, int pageSize, Example e);

    PageDataResult selectByPage(int pageNum, int pageSize, Example e);


    int selectCount(T t);

    int selectCountByExample(Example e);

    int deleteByExample(Example e);

    int deleteByPrimaryKey(Object key);
}
