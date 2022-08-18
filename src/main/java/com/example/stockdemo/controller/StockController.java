package com.example.stockdemo.controller;

import com.example.stockdemo.entity.Stock;
import com.example.stockdemo.service.IStockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author emmith
 * @since 2022-08-17
 */
@RestController
@RequestMapping("/stockdemo/stock")
public class StockController {

    @Resource
    IStockService stockService;


    @GetMapping("/list")
    public List<Stock> getStockList() {
        return stockService.list();
    }
}
