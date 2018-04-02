package com.zhenghao.rule.management.repository.dao;

import com.zhenghao.rule.management.common.convert.RuleConvert;
import com.zhenghao.rule.management.common.model.RulePO;
import com.zhenghao.rule.management.contract.vo.Rule;
import com.zhenghao.rule.management.repository.mapper.RulePOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RuleRepository {

    @Autowired
    private RulePOMapper rulePOMapper;

    public List<Rule> listAll() {
        return rulePOMapper.selectByExample(null).stream()
                .map(RuleConvert::fromPO)
                .collect(Collectors.toList());
    }

    public Rule getById(long id) {
        return RuleConvert.fromPO(rulePOMapper.selectByPrimaryKey(id));
    }

    public long insert(Rule rule) {
        RulePO rulePO = RuleConvert.toPO(rule);
        rulePOMapper.insert(rulePO);
        return rulePO.getId();
    }

    public void update(Rule rule) {
        RulePO rulePO = RuleConvert.toPO(rule);
        rulePOMapper.updateByPrimaryKey(rulePO);
    }

    public void delete(long id) {
        rulePOMapper.deleteByPrimaryKey(id);
    }
}
