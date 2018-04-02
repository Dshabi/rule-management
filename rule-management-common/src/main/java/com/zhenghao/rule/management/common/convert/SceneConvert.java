package com.zhenghao.rule.management.common.convert;

import com.zhenghao.rule.management.common.model.ScenePO;
import com.zhenghao.rule.management.common.util.ModelUtils;
import com.zhenghao.rule.management.contract.vo.Scene;

public class SceneConvert {

    public static Scene fromPO(ScenePO scenePO) {
        return ModelUtils.map(scenePO, Scene.class);
    }

    public static ScenePO toPO(Scene scene) {
        return ModelUtils.map(scene, ScenePO.class);
    }
}
