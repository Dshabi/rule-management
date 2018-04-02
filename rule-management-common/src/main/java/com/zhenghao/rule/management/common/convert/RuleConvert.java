package com.zhenghao.rule.management.common.convert;

import com.zhenghao.rule.management.common.model.RulePO;
import com.zhenghao.rule.management.common.util.ModelUtils;
import com.zhenghao.rule.management.contract.vo.Rule;

public class RuleConvert {

    public static Rule fromPO(RulePO rulePO) {
        return ModelUtils.map(rulePO, Rule.class);
    }

    public static RulePO toPO(Rule rule) {
        return ModelUtils.map(rule, RulePO.class);
    }
}
