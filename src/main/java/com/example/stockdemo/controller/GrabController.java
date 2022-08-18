package com.example.stockdemo.controller;


import com.example.stockdemo.common.BusinessException;
import com.example.stockdemo.entity.dto.DescStockDTO;
import com.example.stockdemo.service.GrabService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/stockdemo/grab")
public class GrabController {

    @Resource
    GrabService grabService;

    @PostMapping()
    public boolean grab(@RequestBody DescStockDTO descStockDTO) {
        boolean res = false;
        try {
            res = grabService.grab(descStockDTO);
        } catch (BusinessException e) {
            res = false;
        }
        return res;
    }
}
