package com.zhenghao.rule.management.common.convert;

import com.zhenghao.rule.management.common.model.RulePO;
import com.zhenghao.rule.management.common.util.ModelHelper;
import com.zhenghao.rule.management.contract.vo.Rule;

public class RuleConvert {

    public static Rule fromPO(RulePO rulePO) {
        return ModelHelper.map(rulePO, Rule.class);
    }

    public static RulePO toPO(Rule rule) {
        return ModelHelper.map(rule, RulePO.class);
    }
}
