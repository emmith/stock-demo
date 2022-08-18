package com.example.stockdemo.service.impl;

import com.example.stockdemo.entity.StockFlow;
import com.example.stockdemo.mapper.StockFlowMapper;
import com.example.stockdemo.service.IStockFlowService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 库存流水表 服务实现类
 * </p>
 *
 * @author emmith
 * @since 2022-08-18
 */
@Service
public class StockFlowServiceImpl extends ServiceImpl<StockFlowMapper, StockFlow> implements IStockFlowService {

}
