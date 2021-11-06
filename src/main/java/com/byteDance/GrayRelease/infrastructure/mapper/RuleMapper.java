package com.byteDance.GrayRelease.infrastructure.mapper;


import com.byteDance.GrayRelease.infrastructure.pojo.Req;
import com.byteDance.GrayRelease.infrastructure.pojo.RuleDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 数据库操作接口
 */
@Mapper
@Repository
public interface RuleMapper {

    List<RuleDO> selectList(Req req);

    void insertRule(RuleDO ruleDO);

}
