package com.zhenghao.rule.management.repository.mapper;

import com.zhenghao.rule.management.common.model.AttributePO;
import com.zhenghao.rule.management.common.model.AttributePOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface AttributePOMapper {
    long countByExample(AttributePOExample example);

    int deleteByExample(AttributePOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AttributePO record);

    int insertSelective(AttributePO record);

    List<AttributePO> selectByExampleWithRowbounds(AttributePOExample example, RowBounds rowBounds);

    List<AttributePO> selectByExample(AttributePOExample example);

    AttributePO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AttributePO record, @Param("example") AttributePOExample example);

    int updateByExample(@Param("record") AttributePO record, @Param("example") AttributePOExample example);

    int updateByPrimaryKeySelective(AttributePO record);

    int updateByPrimaryKey(AttributePO record);
}