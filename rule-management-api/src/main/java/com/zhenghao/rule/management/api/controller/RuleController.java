package com.zhenghao.rule.management.api.controller;

import com.zhenghao.rule.management.contract.response.BaseResponse;
import com.zhenghao.rule.management.contract.vo.Rule;
import com.zhenghao.rule.management.service.RuleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rule")
public class RuleController {

    @Autowired
    private RuleServiceImpl ruleService;

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public BaseResponse listAll() {
        return BaseResponse.newSuccessResponse(ruleService.listAll());
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public BaseResponse insert(@RequestBody Rule rule) {
        return BaseResponse.newSuccessResponse(ruleService.insert(rule));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public BaseResponse update(@RequestBody Rule rule) {
        return BaseResponse.newSuccessResponse(ruleService.update(rule));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public BaseResponse delete(@PathVariable long id) {
        return BaseResponse.newSuccessResponse(ruleService.delete(id));
    }

}
