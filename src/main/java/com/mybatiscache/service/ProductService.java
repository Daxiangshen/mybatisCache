package com.mybatiscache.service;

import com.mybatiscache.pojo.Product;

import java.util.List;

/**
 * ProductService interface
 *
 * @author yuxiang
 * @since 2019/7/10
 * */
public interface ProductService {

    /**
     * 查询所有信息
     *
     * @param id
     *
     *
     * @return List<Product>
     * */
    List<Product> queryAll(Long id);


    /**
     * 修改信息
     *
     * @param product
     *
     *
     * @return int
     * */
    boolean updateMsg(Product product);
}
