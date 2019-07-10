package com.mybatiscache.controller;

import com.mybatiscache.pojo.Product;
import com.mybatiscache.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/queryProduct")
    public List<Product> getProductInfo(){
        List<Product> product=productService.selectProduct();
        return product;
    }

//    @PutMapping("/{id}")
//    public Product updateProductInfo(@PathVariable("id") Long id,@RequestBody Product newProduct){
//        //TODO
//        return null;
//    }
}
