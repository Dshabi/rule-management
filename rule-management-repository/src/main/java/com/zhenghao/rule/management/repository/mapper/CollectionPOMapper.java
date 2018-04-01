package com.zhenghao.rule.management.repository.mapper;

import com.zhenghao.rule.management.common.model.CollectionPO;
import com.zhenghao.rule.management.common.model.CollectionPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CollectionPOMapper {
    long countByExample(CollectionPOExample example);

    int deleteByExample(CollectionPOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CollectionPO record);

    int insertSelective(CollectionPO record);

    List<CollectionPO> selectByExampleWithRowbounds(CollectionPOExample example, RowBounds rowBounds);

    List<CollectionPO> selectByExample(CollectionPOExample example);

    CollectionPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CollectionPO record, @Param("example") CollectionPOExample example);

    int updateByExample(@Param("record") CollectionPO record, @Param("example") CollectionPOExample example);

    int updateByPrimaryKeySelective(CollectionPO record);

    int updateByPrimaryKey(CollectionPO record);
}