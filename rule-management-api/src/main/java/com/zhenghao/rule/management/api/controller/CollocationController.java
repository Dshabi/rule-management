package com.zhenghao.rule.management.api.controller;

import com.zhenghao.rule.management.contract.response.BaseResponse;
import com.zhenghao.rule.management.contract.vo.Collocation;
import com.zhenghao.rule.management.service.CollocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/collocation")
public class CollocationController {

    @Autowired
    private CollocationServiceImpl collocationService;

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public BaseResponse listAll() {
        return BaseResponse.newSuccessResponse(collocationService.listAll());
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public BaseResponse insert(@RequestBody Collocation collocation) {
        return BaseResponse.newSuccessResponse(collocationService.insert(collocation));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public BaseResponse update(@RequestBody Collocation collocation) {
        return BaseResponse.newSuccessResponse(collocationService.update(collocation));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public BaseResponse delete(@PathVariable Long id) {
        return BaseResponse.newSuccessResponse(collocationService.delete(id));
    }
}