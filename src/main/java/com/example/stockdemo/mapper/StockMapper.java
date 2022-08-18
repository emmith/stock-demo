package com.example.stockdemo.mapper;

import com.example.stockdemo.entity.Stock;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author emmith
 * @since 2022-08-17
 */
@Mapper
public interface StockMapper extends BaseMapper<Stock> {

}
