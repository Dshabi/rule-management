package com.zhenghao.rule.management.service;

import com.zhenghao.rule.management.contract.vo.Collocation;
import com.zhenghao.rule.management.contract.vo.Rule;
import com.zhenghao.rule.management.contract.vo.Scene;
import com.zhenghao.rule.management.repository.dao.CollocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CollocationServiceImpl {

    @Autowired
    private CollocationRepository collocationRepository;

    @Autowired
    private SceneServiceImpl sceneService;

    @Autowired
    private RuleServiceImpl ruleService;

    public List<Collocation> listAll() {
        return collocationRepository.listAll().stream()
                .map(this::assembleCollocation)
                .collect(Collectors.toList());
    }

    public List<Collocation> listBySceneId(long sceneId) {
        return collocationRepository.listBySceneId(sceneId).stream()
                .map(this::assembleCollocation)
                .collect(Collectors.toList());
    }

    public boolean insert(Collocation collocation) {
        long sceneId = collocation.getSceneId();
        long ruleId = collocation.getRuleId();

        if (sceneService.getById(sceneId) == null) {
            throw new IllegalArgumentException("Scene Id不存在。Id: " + sceneId);
        }
        if (ruleService.getById(ruleId) == null) {
            throw new IllegalArgumentException("Rule Id不存在。Id: " + ruleId);
        }
        if (collocationRepository.getBySceneIdAndRuleId(sceneId, ruleId) != null) {
            throw new IllegalArgumentException("配置已存在。Scene Id: " + sceneId + "; Rule Id: " + ruleId);
        }

        collocationRepository.insert(collocation);
        return true;
    }

    public boolean update(Collocation collocation) {
        collocationRepository.update(collocation);
        return true;
    }

    //TODO 删除前依赖检查
    public boolean delete(long id) {
        collocationRepository.delete(id);
        return true;
    }

    private Collocation assembleCollocation(Collocation collocation) {
        Scene scene = sceneService.getById(collocation.getSceneId());
        collocation.setScene(scene);

        Rule rule = ruleService.getWithConditions(collocation.getRuleId());
        collocation.setRule(rule);

        return collocation;
    }
}
