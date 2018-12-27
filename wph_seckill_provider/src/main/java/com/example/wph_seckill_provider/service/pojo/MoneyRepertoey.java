package com.example.wph_seckill_provider.service.pojo;

import java.io.Serializable;

public class MoneyRepertoey implements Serializable {
    private  String pinpaiID;
    private String reperId;
    private Integer number;

    public String getPinpaiID() {
        return pinpaiID;
    }

    public void setPinpaiID(String pinpaiID) {
        this.pinpaiID = pinpaiID;
    }

    public String getReperId() {
        return reperId;
    }

    public void setReperId(String reperId) {
        this.reperId = reperId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
