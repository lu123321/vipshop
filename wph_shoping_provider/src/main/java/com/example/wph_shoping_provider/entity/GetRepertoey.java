package com.example.wph_shoping_provider.entity;

import java.io.Serializable;
import java.util.Date;

public class GetRepertoey  implements Serializable {
    private  String productId; //商品编号
    private  Integer number;    //商品数量
    private  Date  datetime;   //商品上架时间
    private String pinpaiId;   //品牌Id

    public String getPinpaiId() {
        return pinpaiId;
    }

    public void setPinpaiId(String pinpaiId) {
        this.pinpaiId = pinpaiId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}
