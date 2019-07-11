package com.mybatiscache.dao;

import com.mybatiscache.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ProductMapper interface
 *
 * @author yuxiang
 * @since 2019/7/10
 * */
public interface ProductMapper{

    /**
     * 查询所有信息
     *
     * @param id
     *
     * @return List<Product>
     * */
    List<Product> queryAll(@Param("id") Long id);

    /**
     * 修改信息
     *
     *
     * @param product
     *
     *
     * @return int
     * */
    int updateMsg(@Param("product") Product product);
}
