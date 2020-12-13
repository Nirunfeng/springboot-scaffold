package com.example.travels.service.Impl;

import com.example.travels.dao.ProvinceDao;
import com.example.travels.entity.Province;
import com.example.travels.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description:
 * @Author: Ni RunF
 * @Date: 2020/12/13 13:28
 * @Version：1.0
 */
@Service
@Transactional
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    private ProvinceDao provinceDao;

    /**
     * 分页业务
     * @param curpage(当前页)
     * @param rows(显示的记录数)
     * @return
     */
    @Override
    public List<Province> findByPage(Integer curpage, Integer rows) {
        /*计算start=(page-1)*rows:当前页的起始条数*/
        int start=(curpage-1)*rows;
        return provinceDao.findByPage(start,rows);
    }

    /**
     * 总条数
     * @return
     */
    @Override
    public Integer findTotals() {
        return provinceDao.findTotals();
    }
}
