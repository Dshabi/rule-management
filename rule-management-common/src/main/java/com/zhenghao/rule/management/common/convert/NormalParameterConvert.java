package com.zhenghao.rule.management.common.convert;


import com.zhenghao.rule.management.common.model.NormalParameterPO;
import com.zhenghao.rule.management.common.util.ModelHelper;
import com.zhenghao.rule.management.contract.vo.NormalParameter;

public class NormalParameterConvert {

    public static NormalParameter fromPO(NormalParameterPO NormalParameterPO) {
        return ModelHelper.map(NormalParameterPO, NormalParameter.class);
    }

    public static NormalParameterPO toPO(NormalParameter NormalParameter) {
        return ModelHelper.map(NormalParameter, NormalParameterPO.class);
    }
}
