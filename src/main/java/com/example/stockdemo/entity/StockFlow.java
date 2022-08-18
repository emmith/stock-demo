package com.example.stockdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * <p>
 * 库存流水表
 * </p>
 *
 * @author emmith
 * @since 2022-08-18
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("stock_flow")
public class StockFlow {

    /**
     * 流水号id，用于订单取消时，回查流水恢复库存
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品ID
     */
    @TableField("sku_id")
    private Integer skuId;

    /**
     * 关联的订单id
     */
    @TableField("order_id")
    private Integer orderId;

    /**
     * 购买数量
     */
    @TableField("quantity_number")
    private Integer quantityNumber;


}
