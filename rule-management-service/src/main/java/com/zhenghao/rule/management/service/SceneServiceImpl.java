package com.zhenghao.rule.management.service;

import com.zhenghao.rule.management.contract.vo.Scene;
import com.zhenghao.rule.management.repository.dao.SceneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SceneServiceImpl {

    @Autowired
    private SceneRepository sceneRepository;

    public List<Scene> listAllScene() {
        return sceneRepository.listAllScene();
    }

    public boolean insert(Scene scene) {
        sceneRepository.insert(scene);
        return true;
    }
}