package com.zuishuai.cn.controller;

import com.zuishuai.cn.entity.Cart;
import com.zuishuai.cn.entity.User;
import com.zuishuai.cn.service.UserService;
import com.zuishuai.cn.utils.LoginUserUtils;
import com.zuishuai.cn.utils.ServletUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author luozuishuai
 * @Created on 2020-12-17 11:17
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public String register(User user, HttpSession session){
        session.setAttribute("username",user.getUsername());
        if(user.getUsername() == "" || user.getPassword() == ""){
            session.setAttribute("message","用户名密码不能为空");
            //跳转回注册页面 提示错误信息并回显用户名
            return "redirect:/toRegister";
        }
        int row = userService.registUser(user);
        if(row > 0){
            //说明注册成功
            //跳转到登录页面
            session.setAttribute("message",null);
            return "redirect:/toLogin";
        }else if(row == -1){
            session.setAttribute("message","用户名已存在");
            return "redirect:/toRegister";
        }else{
            session.setAttribute("message","注册信息有误");
            //跳转回注册页面 提示错误信息并回显用户名
            return "redirect:/toRegister";
        }
    }

    @PostMapping("login")
    public String login(User user){
        HttpSession session = ServletUtils.getSession();
        session.setAttribute("username",user.getUsername());
        if(user.getUsername() == "" || user.getPassword() == ""){
            session.setAttribute("message","用户名密码不能为空");
            //跳转回登录页面 提示错误信息并回显用户名
            return "redirect:/toLogin";
        }
        User loginUser = userService.loginUser(user);
        if(loginUser != null){
            //说明注册成功 保存用户到session中
            LoginUserUtils.setLoginUser(user);
            //加载商品信息 然后跳转到商城首页
            return "redirect:/good/list";
        }else{
            session.setAttribute("message","用户名或密码错误");
            //跳转回登录页面 提示错误信息并回显用户名
            return "redirect:/toLogin";
        }

    }

    //获取用户购物车
    @GetMapping("getCart")
    public String getUserCart(Model model){
        Cart cart = userService.getUserCart();
        model.addAttribute("cart",cart);
        return "shopcart";
    }
}
