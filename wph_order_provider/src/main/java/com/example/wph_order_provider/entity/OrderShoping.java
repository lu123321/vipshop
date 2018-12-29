package com.example.wph_order_provider.entity;

import java.util.Date;
import java.util.List;

public class OrderShoping {
    //订单id
    private Integer orderId;

    //订单编号,时间戳+用户id
    private String orderNo;


    //订单状态 未支付0, 已取消1, 待收货2, 待发货3, 待评价4
    private Integer orderState;

    //下单时间
    private Date orderTime;

    //用户id
    private Integer userId;

    //支付方式 默认支付宝
    private String orderPayment;

    //支付金额
    private Integer orderMoney;

    //支付单号
    private String orderpaynumber;

    //运单号
    private String orderwaybill;

    //收货地址
    private String orderadress;

    private List<WphOrderShoping> wphOrderShoping;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOrderPayment() {
        return orderPayment;
    }

    public void setOrderPayment(String orderPayment) {
        this.orderPayment = orderPayment;
    }

    public Integer getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Integer orderMoney) {
        this.orderMoney = orderMoney;
    }

    public String getOrderpaynumber() {
        return orderpaynumber;
    }

    public void setOrderpaynumber(String orderpaynumber) {
        this.orderpaynumber = orderpaynumber;
    }

    public String getOrderwaybill() {
        return orderwaybill;
    }

    public void setOrderwaybill(String orderwaybill) {
        this.orderwaybill = orderwaybill;
    }

    public String getOrderadress() {
        return orderadress;
    }

    public void setOrderadress(String orderadress) {
        this.orderadress = orderadress;
    }

    public List<WphOrderShoping> getWphOrderShoping() {
        return wphOrderShoping;
    }

    public void setWphOrderShoping(List<WphOrderShoping> wphOrderShoping) {
        this.wphOrderShoping = wphOrderShoping;
    }
}
