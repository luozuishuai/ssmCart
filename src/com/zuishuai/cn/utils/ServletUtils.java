package com.zuishuai.cn.utils;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author luozuishuai
 * @Created on 2020-12-17 15:50
 */
public class ServletUtils {

    //请求
    public static HttpServletRequest getRequest(){
        return getServletRequestAttributes().getRequest();
    }

    //获取请求属性
    public static ServletRequestAttributes getServletRequestAttributes(){
        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }


    //响应
    public static HttpServletResponse getResponse(){
        return getServletRequestAttributes().getResponse();
    }

    //session
    public static HttpSession getSession(){
        return getRequest().getSession();
    }


}
