package com.zuishuai.cn.service.impl;

import com.zuishuai.cn.entity.Cart;
import com.zuishuai.cn.entity.Cartitem;
import com.zuishuai.cn.entity.Good;
import com.zuishuai.cn.mapper.CartMapper;
import com.zuishuai.cn.mapper.GoodMapper;
import com.zuishuai.cn.service.CartService;
import com.zuishuai.cn.utils.LoginUserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author luozuishuai
 * @Created on 2020-12-17 15:34
 */
@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private GoodMapper goodMapper;

    @Autowired
    private CartMapper cartMapper;

    @Override
    public void addCart(String goodId) {
        //通过商品id取到商品对象
        Good good = goodMapper.findById(goodId);
        //先要判断用户有没有购物车
        //获取用户的购物车
        Cart cart = cartMapper.findCartByUserId(LoginUserUtils.getUserId());
        if(cart == null){
            //用户没有购物车
            //创建用户的购物车并添加商品 并返回购物车id
            String cartId = initCartDataAndAddCart(good.getPrice());
            //添加购物车的商品项
            initCartItemDataAndAddCartItem(cartId,good);
        }else{
            //用户已存在购物车时，修改购物车信息
            resetCartDataAndUpdateCart(cart,good.getPrice());
            //然后修改用户购物车里的商品信息
            addOrUpdateCartItem(cart,good);
        }

    }


    /**
     * 当用户添加或修改购物车中的商品项时
     * @param cart
     * @param good
     */
    private void addOrUpdateCartItem(Cart cart, Good good) {
        //先查询用户的购物车是否已存在该商品
        Cartitem cartitem = cartMapper.getCartItemByCartIdAndGoodId(cart.getCartId(),good.getPid());
        if(cartitem == null){
            //该商品为新增商品
            initCartItemDataAndAddCartItem(cart.getCartId(),good);
        }else{
            //该商品之前已存在
            resetCartItemDataAndUpdateCartItem(cartitem,good);
        }
    }

    /**
     * 该商品之前已存在 则将该商品项的数量+1 金额加1倍
     * @param cartitem
     * @param good
     */
    private void resetCartItemDataAndUpdateCartItem(Cartitem cartitem, Good good) {
        cartitem.setPnum(cartitem.getPnum()+1);
        cartitem.setPmoney(cartitem.getPmoney()+good.getPrice());
        //将更新后的数据更新到数据库
        cartMapper.updateCartItem(cartitem);
    }

    /**
     * 用户已有购物车时添加商品到购物车,进行修改购物车
     * @param cart
     * @param price
     */
    private void resetCartDataAndUpdateCart(Cart cart, double price) {
        //让用户购物车的总商品数量+1
        cart.setTotalnum(cart.getTotalnum()+1);
        //让用户购物车的的总金额+此商品的金额
        cart.setTotalmoney(cart.getTotalmoney()+price);
        cartMapper.updateCart(cart);
    }

    /**
     * 初始化购物车数据 添加购物车 返回购物车的id值
     */
    public String initCartDataAndAddCart(double goodPrice){
        Cart cart = new Cart();
        //生成随机购物车id
        String cartId = UUID.randomUUID().toString().replaceAll("-", "");
        cart.setCartId(cartId);
        //生成用户id
        cart.setUserId(LoginUserUtils.getUserId());
        //每次点击加入购物车 默认增加一件商品
        cart.setTotalnum(1);
        //获取商品价格
        cart.setTotalmoney(goodPrice);
        cartMapper.addCart(cart);
        return cartId;
    }

    /**
     * 初始化购物车商品项的数据，添加购物车商品
     */
    public void initCartItemDataAndAddCartItem(String cartId,Good good){
        Cartitem cartitem = new Cartitem();
        cartitem.setCartId(cartId);
        //生成随机购物车商品项id
        String cartItemId = UUID.randomUUID().toString().replaceAll("-", "");
        cartitem.setCartItemId(cartItemId);
        cartitem.setPid(good.getPid());
        cartitem.setPmoney(good.getPrice());
        cartitem.setPnum(1);
        cartMapper.addCartItem(cartitem);
    }
}
