package com.example.wphticketsprovider.entity;

import java.io.Serializable;

public class User implements Serializable {
    private Integer uid;
    private Integer utype;  //用户类别
    private String u1;
    private String u2;
    private String u3;

    public String getU1() {
        return u1;
    }

    public void setU1(String u1) {
        this.u1 = u1;
    }

    public String getU2() {
        return u2;
    }

    public void setU2(String u2) {
        this.u2 = u2;
    }

    public String getU3() {
        return u3;
    }

    public void setU3(String u3) {
        this.u3 = u3;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getUtype() {
        return utype;
    }

    public void setUtype(Integer utype) {
        this.utype = utype;
    }
}
