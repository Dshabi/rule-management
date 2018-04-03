package com.zhenghao.rule.management.api.controller;

import com.zhenghao.rule.management.contract.response.BaseResponse;
import com.zhenghao.rule.management.contract.vo.NormalParameter;
import com.zhenghao.rule.management.service.NormalParameterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/normalParameter")
public class NormalParameterController {

    @Autowired
    private NormalParameterServiceImpl normalParameterService;

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public BaseResponse listAll() {
        return BaseResponse.newSuccessResponse(normalParameterService.listAll());
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public BaseResponse insert(@RequestBody NormalParameter normalParameter) {
        return BaseResponse.newSuccessResponse(normalParameterService.insert(normalParameter));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public BaseResponse delete(@PathVariable Long id) {
        return BaseResponse.newSuccessResponse(normalParameterService.delete(id));
    }
}
