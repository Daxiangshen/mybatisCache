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
     * 查询
     *
     * @return
     * */
    List<Product> selectProduct();
}
