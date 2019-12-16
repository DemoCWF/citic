package com.citic.demo.base;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 *
 * 类名称：IBaseDao 类描述：Dao基类（声明CRUD常用接口方法)
 */
public interface IBaseDao<T> {
    // 保存
    Integer insert(T entity);

    // 修改
    Integer update(T entity);

    // 删除
    Integer deleteById(Serializable id);

    // 查询（ID）
    T getById(Serializable id);

    // 查询（where）
    List<T> getByWhere(HashMap<String, Object> params);

    // 查询（All）
    List<T> getAll();

    // 查询（分页查询_结果集）
    List<T> findQuery(ObjectQuery objectQuery);

    // 查询（分页查询_数量）
    Integer findCount(ObjectQuery objectQuery);
}