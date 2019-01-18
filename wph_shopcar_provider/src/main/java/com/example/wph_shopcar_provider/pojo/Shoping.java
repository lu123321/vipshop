package com.example.wph_shopcar_provider.pojo;

import java.io.Serializable;

public class Shoping implements Serializable {
    private String shopingname;
    private String shopingnumber;
    private double shopingmoney;
    private String picture;
    private Integer shopingnum;
    private Integer brand;
    private Integer userid;
    private Integer spuid;
    private double shopingprice;
    private long s;

    public long getS() {
        return s;
    }

    public void setS(long s) {
        this.s = s;
    }

    public Shoping(){}

    public String getShopingname() {
        return shopingname;
    }

    public void setShopingname(String shopingname) {
        this.shopingname = shopingname;
    }

    public String getShopingnumber() {
        return shopingnumber;
    }

    public void setShopingnumber(String shopingnumber) {
        this.shopingnumber = shopingnumber;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getShopingnum() {
        return shopingnum;
    }

    public void setShopingnum(Integer shopingnum) {
        this.shopingnum = shopingnum;
    }

    public Integer getBrand() {
        return brand;
    }

    public void setBrand(Integer brand) {
        this.brand = brand;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getSpuid() {
        return spuid;
    }

    public void setSpuid(Integer spuid) {
        this.spuid = spuid;
    }

    public double getShopingmoney() {
        return shopingmoney;
    }

    public void setShopingmoney(double shopingmoney) {
        this.shopingmoney = shopingmoney;
    }

    public double getShopingprice() {
        return shopingprice;
    }

    public void setShopingprice(double shopingprice) {
        this.shopingprice = shopingprice;
    }
}
