package com.zuishuai.cn.entity;


public class Cartitem {

  private String cartItemId;
  private String cartId;
  private String pid;
  private long pnum;
  private double pmoney;

  private Good good;

  public Good getGood() {
    return good;
  }

  public void setGood(Good good) {
    this.good = good;
  }

  public String getCartItemId() {
    return cartItemId;
  }

  public void setCartItemId(String cartItemId) {
    this.cartItemId = cartItemId;
  }


  public String getCartId() {
    return cartId;
  }

  public void setCartId(String cartId) {
    this.cartId = cartId;
  }


  public String getPid() {
    return pid;
  }

  public void setPid(String pid) {
    this.pid = pid;
  }


  public long getPnum() {
    return pnum;
  }

  public void setPnum(long pnum) {
    this.pnum = pnum;
  }


  public double getPmoney() {
    return pmoney;
  }

  public void setPmoney(double pmoney) {
    this.pmoney = pmoney;
  }

}
