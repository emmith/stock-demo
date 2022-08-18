package com.example.stockdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.stockdemo.common.BusinessException;
import com.example.stockdemo.entity.Stock;
import com.example.stockdemo.entity.StockFlow;
import com.example.stockdemo.entity.dto.DescStockDTO;
import com.example.stockdemo.mapper.StockFlowMapper;
import com.example.stockdemo.mapper.StockMapper;
import com.example.stockdemo.service.GrabService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Slf4j
public class GrabServiceImpl implements GrabService {

    @Resource
    StockMapper stockMapper;

    @Resource
    StockFlowMapper stockFlowMapper;

    @Override
    @Transactional
    public boolean grab(DescStockDTO descStockDTO) {
        UpdateWrapper<Stock> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", descStockDTO.getStockId());
        updateWrapper.ge("total", descStockDTO.getNum());
        updateWrapper.setSql(String.format("total=total-%d", descStockDTO.getNum()));
        StockFlow stockFlow = StockFlow.builder()
                .skuId(descStockDTO.getStockId())
                .orderId(descStockDTO.getOrderId())
                .quantityNumber(descStockDTO.getNum())
                .build();
        stockFlowMapper.insert(stockFlow);
        int res = stockMapper.update(null, updateWrapper);
        if (res <= 0) {
            log.error("扣减库存失败");
            //我们希望扣减库存成功和记录流水表是事务的
            throw new BusinessException("扣减库存失败");
        }
        return true;
    }
}
