package com.zuishuai.cn.config;

import com.zuishuai.cn.interceptors.LoginInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author luozuishuai
 * @Created on 2020-12-16 23:46
 */
@Configuration
@ComponentScan("com.zuishuai.cn.controller")
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{

    //配置视图解析器
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        registry.viewResolver(viewResolver);
    }

    //默认放行静态资源
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    //通过一个路径 跳转到jsp视图 中间没有业务逻辑
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //"/"默认跳转到商城首页
        registry.addRedirectViewController("/","/good/list");
        //注册页面
        registry.addViewController("/toRegister").setViewName("register");
        //登录页面
        registry.addViewController("/toLogin").setViewName("login");
        //商城首页
//        registry.addViewController("/index").setViewName("home");
    }

    //配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/user/getCart","/cart/addCart");
    }
}
