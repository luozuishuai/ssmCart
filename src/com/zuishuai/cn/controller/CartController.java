package com.zuishuai.cn.controller;

import com.zuishuai.cn.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author luozuishuai
 * @Created on 2020-12-17 15:31
 */
@Controller
@RequestMapping("cart")
public class CartController {

    @Autowired
    private CartService cartService;

    /**
     * 添加商品到购物车
     * @return
     */
    @GetMapping("addCart")
    public String addCart(String goodId){
        cartService.addCart(goodId);
        return "redirect:/user/getCart";
    }
}
