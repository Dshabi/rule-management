package com.zhenghao.rule.management.repository.dao;

import com.zhenghao.rule.management.common.convert.SceneConvert;
import com.zhenghao.rule.management.common.model.ScenePO;
import com.zhenghao.rule.management.common.util.ModelHelper;
import com.zhenghao.rule.management.contract.vo.Scene;
import com.zhenghao.rule.management.repository.mapper.ScenePOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SceneRepository {

    @Autowired
    private ScenePOMapper scenePOMapper;

    public List<Scene> listAll() {
        return scenePOMapper.selectByExample(null).stream()
                .map(SceneConvert::fromPO)
                .collect(Collectors.toList());
    }

    public Scene getById(long id) {
        ScenePO scenePO = scenePOMapper.selectByPrimaryKey(id);
        return SceneConvert.fromPO(scenePO);
    }

    public long insert(Scene scene) {
        ScenePO scenePO = SceneConvert.toPO(scene);
        scenePOMapper.insertSelective(scenePO);
        return scenePO.getId();
    }
}
