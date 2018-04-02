package com.zhenghao.rule.management.api.controller;

import com.zhenghao.rule.management.contract.response.BaseResponse;
import com.zhenghao.rule.management.contract.vo.Scene;
import com.zhenghao.rule.management.service.SceneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/scene")
public class SceneController {

    @Autowired
    private SceneServiceImpl sceneService;

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public BaseResponse listAllScene() {
        return BaseResponse.newSuccessResponse(sceneService.listAllScene());
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public BaseResponse insertScene(@RequestBody Scene scene) {
        return BaseResponse.newSuccessResponse(sceneService.insert(scene));
    }
}
