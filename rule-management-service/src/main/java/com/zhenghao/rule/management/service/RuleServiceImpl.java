package com.zhenghao.rule.management.service;

import com.zhenghao.rule.management.contract.vo.Condition;
import com.zhenghao.rule.management.contract.vo.Rule;
import com.zhenghao.rule.management.repository.dao.ConditionRepository;
import com.zhenghao.rule.management.repository.dao.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RuleServiceImpl {

    private static final String CONDITION_IDS_DELIMITER = "_";

    @Autowired
    private RuleRepository ruleRepository;

    @Autowired
    private ConditionRepository conditionRepository;

    public List<Rule> listAll() {
        return ruleRepository.listAll().stream()
                .map(this::fitConditions)
                .collect(Collectors.toList());
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean insert(Rule rule) {
        String relConditionIds = insertConditions(rule.getConditions());
        rule.setRelConditionIds(relConditionIds);

        ruleRepository.insert(rule);
        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean update(Rule rule) {
        long id = rule.getId();

        Rule old = ruleRepository.getById(id);
        List<Long> oldConditionIds = listFromExpression(old.getRelConditionIds());
        conditionRepository.deleteByIds(oldConditionIds);

        String relConditionIds = insertConditions(rule.getConditions());
        rule.setRelConditionIds(relConditionIds);
        ruleRepository.update(rule);

        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean delete(long id) {
        Rule rule = ruleRepository.getById(id);

        List<Long> conditionIds = listFromExpression(rule.getRelConditionIds());
        conditionRepository.deleteByIds(conditionIds);

        ruleRepository.delete(id);
        return true;
    }

    private Rule fitConditions(Rule rule) {
        List<Long> conditionIds = listFromExpression(rule.getRelConditionIds());

        rule.setConditions(conditionRepository.listByIds(conditionIds));
        return rule;
    }

    private List<Long> listFromExpression(String expression) {
        return Arrays.stream(expression.split(CONDITION_IDS_DELIMITER))
                .map(Long::valueOf)
                .collect(Collectors.toList());
    }

    private String insertConditions(List<Condition> conditions) {
        List<String> conditionIds = conditions.stream()
                .map(conditionRepository::insert)
                .map(String::valueOf)
                .collect(Collectors.toList());
        return String.join("_", conditionIds);
    }

}
