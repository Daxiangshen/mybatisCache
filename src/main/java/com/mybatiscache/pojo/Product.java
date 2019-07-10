package com.mybatiscache.pojo;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
/**
 * Product Class
 *
 * @author yuxiang
 * @since 2019/7/10
 * */
@Data
public class Product extends Model<Product> implements Serializable{

    private static final long serialVersionUID = -7805392930118153776L;

    /**
     * 产品id
     * */
    private long id;

    /**
     * 产品名称
     * */
    private String name;

    /**
     * 产品价格
     * */
    private long price;
}
