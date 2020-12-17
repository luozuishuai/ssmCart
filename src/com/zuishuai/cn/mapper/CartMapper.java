package com.zuishuai.cn.mapper;

import com.zuishuai.cn.entity.Cart;
import com.zuishuai.cn.entity.Cartitem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author luozuishuai
 * @Created on 2020-12-17 15:33
 */
public interface CartMapper {

    @Insert("insert into cart(cartId,userId,totalnum,totalmoney) values(#{cartId},#{userId},#{totalnum},#{totalmoney}) ")
    void addCart(Cart cart);

    @Select("select * from cart where userId = #{userId}")
    Cart findCartByUserId(long userId);

    @Insert("insert into cartitem(cartItemId,cartId,pid,pnum,pmoney) values(#{cartItemId},#{cartId},#{pid},#{pnum},#{pmoney})")
    void addCartItem(Cartitem cartitem);

    @Select("select * from cartitem where cartId = #{cartId}")
    List<Cartitem> findCartItemByCartId(String cartId);

    @Select("select * from cartitem where cartId = #{cartId} and pid = #{pid}")
    Cartitem getCartItemByCartIdAndGoodId(@Param("cartId") String cartId, @Param("pid") String pid);

    @Update("update cartitem set pnum = #{pnum},pmoney=#{pmoney} where cartItemId=#{cartItemId}")
    void updateCartItem(Cartitem cartitem);

    @Update("update cart set totalnum=#{totalnum},totalmoney=#{totalmoney} where cartId=#{cartId}")
    void updateCart(Cart cart);
}
