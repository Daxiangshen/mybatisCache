package com.mybatiscache.controller;

import com.mybatiscache.pojo.Product;
import com.mybatiscache.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * ProductController Class
 *
 * @author yuxiang
 * @since 2019/7/10
 * */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @GetMapping("/{id}")
    public List<Product> getProductInfo(@PathVariable("id") Long id){
        List<Product> product=productService.queryAll(id);
        return product;
    }

    @PutMapping("/update")
    public boolean updateProductInfo(@RequestBody Product product){
        return productService.updateMsg(product);
    }
}
