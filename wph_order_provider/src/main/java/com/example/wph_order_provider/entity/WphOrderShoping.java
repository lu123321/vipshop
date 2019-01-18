package com.example.wph_order_provider.entity;

import java.io.Serializable;

/**
 * (WphOrderShoping)实体类
 *
 * @author makejava
 * @since 2018-12-19 18:50:28
 */
public class WphOrderShoping implements Serializable {
    private static final long serialVersionUID = 991079785015173973L;

    public WphOrderShoping(){}

    //订单商品
    private Integer orderShopingId;

    //订单编号
    private Integer orderId;

    //商品编号
    private String skuSerialnumber;

    //订单商品数量
    private Integer orderShopingNum;

    //订单商品小计
    private double ordershopingmoney;

    private String skuname;//

    private Integer skumoney;//

    private String picture;  //

    private Integer orderbrand;

    public Integer getOrderbrand() {
        return orderbrand;
    }

    public void setOrderbrand(Integer orderbrand) {
        this.orderbrand = orderbrand;
    }

    public String getSkuname() {
        return skuname;
    }

    public void setSkuname(String skuname) {
        this.skuname = skuname;
    }

    public Integer getSkumoney() {
        return skumoney;
    }

    public void setSkumoney(Integer skumoney) {
        this.skumoney = skumoney;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public double getOrdershopingmoney() {
        return ordershopingmoney;
    }

    public void setOrdershopingmoney(double ordershopingmoney) {
        this.ordershopingmoney = ordershopingmoney;
    }

    public Integer getOrderShopingId() {
        return orderShopingId;
    }

    public void setOrderShopingId(Integer orderShopingId) {
        this.orderShopingId = orderShopingId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSkuSerialnumber() {
        return skuSerialnumber;
    }

    public void setSkuSerialnumber(String skuSerialnumber) {
        this.skuSerialnumber = skuSerialnumber;
    }

    public Integer getOrderShopingNum() {
        return orderShopingNum;
    }

    public void setOrderShopingNum(Integer orderShopingNum) {
        this.orderShopingNum = orderShopingNum;
    }

}