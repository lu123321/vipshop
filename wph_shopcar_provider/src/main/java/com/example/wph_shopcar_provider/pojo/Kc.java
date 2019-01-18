package com.example.wph_shopcar_provider.pojo;

import java.io.Serializable;

public class Kc implements Serializable {
    private String skunumber;
    private Integer skunum;
    private Integer brand;

    public String getSkunumber() {
        return skunumber;
    }

    public void setSkunumber(String skunumber) {
        this.skunumber = skunumber;
    }

    public Integer getSkunum() {
        return skunum;
    }

    public void setSkunum(Integer skunum) {
        this.skunum = skunum;
    }

    public Integer getBrand() {
        return brand;
    }

    public void setBrand(Integer brand) {
        this.brand = brand;
    }
}
