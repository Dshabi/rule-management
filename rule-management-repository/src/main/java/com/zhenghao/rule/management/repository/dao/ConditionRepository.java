package com.zhenghao.rule.management.repository.dao;

import com.zhenghao.rule.management.common.convert.ConditionConvert;
import com.zhenghao.rule.management.common.model.ConditionPO;
import com.zhenghao.rule.management.common.model.ConditionPOExample;
import com.zhenghao.rule.management.contract.vo.Condition;
import com.zhenghao.rule.management.repository.mapper.ConditionPOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ConditionRepository {

    @Autowired
    private ConditionPOMapper conditionPOMapper;

    public List<Condition> listAll() {
        return conditionPOMapper.selectByExample(null).stream()
                .map(ConditionConvert::fromPO)
                .collect(Collectors.toList());
    }

    public List<Condition> listByIds(List<Long> ids) {
        ConditionPOExample example = new ConditionPOExample();
        example.createCriteria().andIdIn(ids);

        return conditionPOMapper.selectByExample(example).stream()
                .map(ConditionConvert::fromPO)
                .collect(Collectors.toList());
    }

    public long insert(Condition condition) {
        ConditionPO conditionPO = ConditionConvert.toPO(condition);
        conditionPOMapper.insert(conditionPO);
        return conditionPO.getId();
    }

    public void delete(long id) {
        conditionPOMapper.deleteByPrimaryKey(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteByIds(List<Long> ids) {
        ConditionPOExample example = new ConditionPOExample();
        example.createCriteria().andIdIn(ids);

        conditionPOMapper.deleteByExample(example);
    }
}
