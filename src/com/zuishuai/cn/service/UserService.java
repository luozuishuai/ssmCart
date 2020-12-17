package com.zuishuai.cn.service;

import com.zuishuai.cn.entity.Cart;
import com.zuishuai.cn.entity.User;

/**
 * @author luozuishuai
 * @Created on 2020-12-17 11:14
 */
public interface UserService {

    /**
     * 用户注册service层接口
     */
    int registUser(User user);

    User loginUser(User user);

    Cart getUserCart();
}
