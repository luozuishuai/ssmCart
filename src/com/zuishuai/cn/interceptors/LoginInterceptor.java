package com.zuishuai.cn.interceptors;

import com.zuishuai.cn.entity.User;
import com.zuishuai.cn.utils.LoginUserUtils;
import com.zuishuai.cn.utils.ServletUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author luozuishuai
 * @Created on 2020-12-17 18:30
 */
public class LoginInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User loginUser = LoginUserUtils.getLoginUser();
        if(loginUser == null){
            response.sendRedirect("/toLogin");
            return false;
        }
        //已登录则放行
        return true;
    }
}
