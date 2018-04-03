package com.zhenghao.rule.management.common.convert;

import com.zhenghao.rule.management.common.model.ScenePO;
import com.zhenghao.rule.management.common.util.ModelHelper;
import com.zhenghao.rule.management.contract.vo.Scene;

public class SceneConvert {

    public static Scene fromPO(ScenePO scenePO) {
        return ModelHelper.map(scenePO, Scene.class);
    }

    public static ScenePO toPO(Scene scene) {
        return ModelHelper.map(scene, ScenePO.class);
    }
}
