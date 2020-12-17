package com.zuishuai.cn.service.impl;

import com.zuishuai.cn.entity.Cart;
import com.zuishuai.cn.entity.Cartitem;
import com.zuishuai.cn.entity.Good;
import com.zuishuai.cn.entity.User;
import com.zuishuai.cn.mapper.CartMapper;
import com.zuishuai.cn.mapper.GoodMapper;
import com.zuishuai.cn.mapper.UserMapper;
import com.zuishuai.cn.service.UserService;
import com.zuishuai.cn.utils.LoginUserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.List;

/**
 * @author luozuishuai
 * @Created on 2020-12-17 11:15
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private GoodMapper goodMapper;

    @Override
    public int registUser(User user) {
        User result = userMapper.findByUsername(user);
        if(result != null){
            return -1;
        }
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        return userMapper.registUser(user);
    }

    @Override
    public User loginUser(User user) {
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        return userMapper.checkUsernameAndPassword(user);
    }

    @Override
    public Cart getUserCart() {
        Cart cart = cartMapper.findCartByUserId(LoginUserUtils.getUserId());
        if(cart != null){
            //如果购物车存在 则需获取购物车中的商品项
            //查找所有属于该购物车的商品项
            List<Cartitem> list = cartMapper.findCartItemByCartId(cart.getCartId());
            list.forEach(cartitem -> {
                Good good = goodMapper.findById(cartitem.getPid());
                cartitem.setGood(good);
            });
            //每一项Cartitems中都有good属性 然后添加到cart中
            cart.setCartitems(list);
        }
        return cart;
    }
}
