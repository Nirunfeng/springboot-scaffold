package com.example.travels.service;

import com.example.travels.entity.Province;

import java.util.List;

/**
 * @Description:
 * @Author: Ni RunF
 * @Date: 2020/12/12 19:28
 * @Version：1.0
 */
public interface ProvinceService {

    /**
     * 分页查询业务
     * @param curpage(当前页)
     * @param rows(显示的记录数)
     * @return
     */
    List<Province> findByPage(Integer curpage,Integer rows);

    /**
     * 查询总条数
     * @return
     */
    Integer findTotals();
}
