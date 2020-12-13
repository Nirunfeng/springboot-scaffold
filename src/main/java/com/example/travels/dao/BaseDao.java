package com.example.travels.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: 可复用数据库操作dao,T代表当前操作类型，K代表主键类型
 * @Author: Ni RunF
 * @Date: 2020/12/12 17:50
 * @Version：1.0
 */
public interface BaseDao<T,K> {

    /*保存数据*/
    void save(T t);

    /*修改数据*/
    void update(T t);

    /*删除数据*/
    void delete(K k);

    /*查询所有*/
    List<T> findAll();

    /*分页查询*/
    List<T> findByPage(@Param("start") Integer start,@Param("rows") Integer rows);

    /*查询总数*/
    Integer findTotals();
}
