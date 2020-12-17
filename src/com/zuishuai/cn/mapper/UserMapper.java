package com.zuishuai.cn.mapper;

import com.zuishuai.cn.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @author luozuishuai
 * @Created on 2020-12-17 11:11
 */

public interface UserMapper {

    /**
     * 用户注册
     */
    @Insert("insert into user(username,password) values(#{username},#{password})")
    int registUser(User user);

    @Select("select * from user where username = #{username} and password = #{password}")
    User checkUsernameAndPassword(User user);

    @Select("select * from user where username = #{username}")
    User findByUsername(User user);
}
