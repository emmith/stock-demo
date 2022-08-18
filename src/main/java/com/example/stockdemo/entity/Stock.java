package com.example.stockdemo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author emmith
 * @since 2022-08-18
 */
@Getter
@Setter
@TableName("stock")
public class Stock {

    /**
     * 商品Id
     */
    @TableId("id")
    private Integer id;

    /**
     * 库存
     */
    @TableField("total")
    private Integer total;


}
