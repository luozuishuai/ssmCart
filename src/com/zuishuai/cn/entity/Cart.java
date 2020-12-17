package com.zuishuai.cn.entity;


import java.util.List;

public class Cart {

  private String cartId;
  private long userId;
  private long totalnum;
  private double totalmoney;

  private List<Cartitem> cartitems;

  @Override
  public String toString() {
    return "Cart{" +
            "cartId='" + cartId + '\'' +
            ", userId=" + userId +
            ", totalnum=" + totalnum +
            ", totalmoney=" + totalmoney +
            ", cartitems=" + cartitems +
            '}';
  }

  public List<Cartitem> getCartitems() {
    return cartitems;
  }

  public void setCartitems(List<Cartitem> cartitems) {
    this.cartitems = cartitems;
  }

  public String getCartId() {
    return cartId;
  }

  public void setCartId(String cartId) {
    this.cartId = cartId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public long getTotalnum() {
    return totalnum;
  }

  public void setTotalnum(long totalnum) {
    this.totalnum = totalnum;
  }


  public double getTotalmoney() {
    return totalmoney;
  }

  public void setTotalmoney(double totalmoney) {
    this.totalmoney = totalmoney;
  }

}
