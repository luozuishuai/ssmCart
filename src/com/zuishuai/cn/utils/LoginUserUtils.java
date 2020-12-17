package com.zuishuai.cn.utils;

import com.zuishuai.cn.entity.User;

/**
 * @author luozuishuai
 * @Created on 2020-12-17 16:00
 */
public class LoginUserUtils {

    private static final String KEY = "loginUser";

    /**
     * 添加登录用户到Session中
     */
    public static void setLoginUser(User user){
        ServletUtils.getSession().setAttribute(KEY,user);
    }

    /**
     * 获取到登录用户
     */
    public static User getLoginUser(){
        return (User)ServletUtils.getSession().getAttribute(KEY);
    }

    /**
     * 获取登录用户的id
     */
    public static long getUserId(){
        return getLoginUser().getId();
    }

    /**
     * 删除用户的登录信息
     */
    public static void releaseLoginUser(){
        ServletUtils.getSession().removeAttribute(KEY);
    }
}
