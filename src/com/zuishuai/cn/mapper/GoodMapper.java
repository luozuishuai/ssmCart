package com.zuishuai.cn.mapper;

import com.zuishuai.cn.entity.Good;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author luozuishuai
 * @Created on 2020-12-17 13:31
 */
public interface GoodMapper {

    @Select("select * from good")
    List<Good> findAll();

    @Select("select * from good where pid = #{goodId}")
    Good findById(String goodId);
}
