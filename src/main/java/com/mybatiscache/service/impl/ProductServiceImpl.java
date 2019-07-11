package com.mybatiscache.service.impl;

import com.mybatiscache.dao.ProductMapper;
import com.mybatiscache.pojo.Product;
import com.mybatiscache.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * ProductServiceImpl Class
 *
 * @author yuxiang
 * @since 2019/7/10
 * */
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;


    @Override
    public List<Product> queryAll(Long id) {
        return productMapper.queryAll(id);
    }

    @Override
    public boolean updateMsg(Product product) {
        if (productMapper.updateMsg(product)<1){
            return false;
        }
        return true;
    }
}
