package com.zhenghao.rule.management.common.convert;

import com.zhenghao.rule.management.common.model.ConditionPO;
import com.zhenghao.rule.management.common.util.ModelUtils;
import com.zhenghao.rule.management.contract.vo.Condition;

public class ConditionConvert {

    public static Condition fromPO(ConditionPO conditionPO) {
        return ModelUtils.map(conditionPO, Condition.class);
    }

    public static ConditionPO toPO(Condition condition) {
        return ModelUtils.map(condition, ConditionPO.class);
    }
}
