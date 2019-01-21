package com.example.wphticketsprovider.entity;

import java.util.List;

public class Couponsandusers {

    private Integer cauid;
    private Integer caucid;       //优惠券id
    private Integer cauuid;       //用户id
    private List<Coupons> coupons;
    private User user;

    public List<Coupons> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<Coupons> coupons) {
        this.coupons = coupons;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getCauid() {
        return cauid;
    }

    public void setCauid(Integer cauid) {
        this.cauid = cauid;
    }

    public Integer getCaucid() {
        return caucid;
    }

    public void setCaucid(Integer caucid) {
        this.caucid = caucid;
    }

    public Integer getCauuid() {
        return cauuid;
    }

    public void setCauuid(Integer cauuid) {
        this.cauuid = cauuid;
    }
}
