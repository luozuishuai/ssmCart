package com.zuishuai.cn.controller;

import com.zuishuai.cn.entity.Cart;
import com.zuishuai.cn.entity.Good;
import com.zuishuai.cn.mapper.UserMapper;
import com.zuishuai.cn.service.GoodService;
import com.zuishuai.cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author luozuishuai
 * @Created on 2020-12-17 13:34
 */
@Controller
@RequestMapping("good")
public class GoodController {

    @Autowired
    private GoodService goodService;


    @GetMapping("list")
    public String list(Model model){
        List<Good> goodList = goodService.findAll();
        model.addAttribute("list",goodList);
        return "home";
    }
}
