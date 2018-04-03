package com.zhenghao.rule.management.service;

import com.zhenghao.rule.management.common.util.ModelHelper;
import com.zhenghao.rule.management.contract.vo.Attribute;
import com.zhenghao.rule.management.contract.vo.NormalParameter;
import com.zhenghao.rule.management.repository.dao.AttributeRepository;
import com.zhenghao.rule.management.repository.dao.NormalParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NormalParameterServiceImpl {

    @Autowired
    private NormalParameterRepository normalParameterRepository;

    @Autowired
    private AttributeRepository attributeRepository;

    public List<NormalParameter> listAll() {
        return normalParameterRepository.listAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean insert(NormalParameter normalParameter) {
        long attributeId = attributeRepository.insert(ModelHelper.map(normalParameter, Attribute.class));
        normalParameter.setAttributeId(attributeId);
        normalParameterRepository.insert(normalParameter);
        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean delete(long id) {
        NormalParameter normalParameter = normalParameterRepository.getById(id);
        attributeRepository.delete(normalParameter.getAttributeId());
        normalParameterRepository.delete(id);
        return true;
    }
}
