package com.zuishuai.cn.entity;


public class Good {

  private String pid;
  private String pname;
  private double price;
  private String pimg;
  private String pdesc;

  @Override
  public String toString() {
    return "Good{" +
            "pid='" + pid + '\'' +
            ", pname='" + pname + '\'' +
            ", price=" + price +
            ", pimg='" + pimg + '\'' +
            ", pdesc='" + pdesc + '\'' +
            '}';
  }

  public String getPid() {
    return pid;
  }

  public void setPid(String pid) {
    this.pid = pid;
  }


  public String getPname() {
    return pname;
  }

  public void setPname(String pname) {
    this.pname = pname;
  }


  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }


  public String getPimg() {
    return pimg;
  }

  public void setPimg(String pimg) {
    this.pimg = pimg;
  }


  public String getPdesc() {
    return pdesc;
  }

  public void setPdesc(String pdesc) {
    this.pdesc = pdesc;
  }

}
