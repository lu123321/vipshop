package com.example.wph_seckill_provider.service.pojo;

import java.io.Serializable;
import java.util.Date;

public class GetRepertoey  implements Serializable {
    private  String productId; //商品编号
    private  Integer number;    //商品数量

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

}
