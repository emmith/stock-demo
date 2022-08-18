package com.example.stockdemo.mapper;

import com.example.stockdemo.entity.StockFlow;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 库存流水表 Mapper 接口
 * </p>
 *
 * @author emmith
 * @since 2022-08-18
 */
@Mapper
public interface StockFlowMapper extends BaseMapper<StockFlow> {

}
