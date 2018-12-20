package com.example.wph_shopcar_provider.pojo;

import java.io.Serializable;

/**
 * (WphSku)实体类
 *
 * @author makejava
 * @since 2018-12-19 09:33:37
 */
public class WphSku implements Serializable {
    private static final long serialVersionUID = -69328711870067159L;
    //商品编号
    private Integer skuId;
    //商品的产品id
    private Integer skuSpuid;
    //商品数量
    private Integer skuNumber;
    //商品价格
    private Object skuMoney;
    //商品编号
    private String skuSerialnumber;
    //商品具体名称
    private String skuName;
    //商品图片
    private Integer skuPictureid;
    //商品状态
    private Integer skuType;
    //冗余列1
    private String sku_1;
    //冗余列2
    private String sku_2;
    //冗余列3
    private String sku_3;


    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Integer getSkuSpuid() {
        return skuSpuid;
    }

    public void setSkuSpuid(Integer skuSpuid) {
        this.skuSpuid = skuSpuid;
    }

    public Integer getSkuNumber() {
        return skuNumber;
    }

    public void setSkuNumber(Integer skuNumber) {
        this.skuNumber = skuNumber;
    }

    public Object getSkuMoney() {
        return skuMoney;
    }

    public void setSkuMoney(Object skuMoney) {
        this.skuMoney = skuMoney;
    }

    public String getSkuSerialnumber() {
        return skuSerialnumber;
    }

    public void setSkuSerialnumber(String skuSerialnumber) {
        this.skuSerialnumber = skuSerialnumber;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public Integer getSkuPictureid() {
        return skuPictureid;
    }

    public void setSkuPictureid(Integer skuPictureid) {
        this.skuPictureid = skuPictureid;
    }

    public Integer getSkuType() {
        return skuType;
    }

    public void setSkuType(Integer skuType) {
        this.skuType = skuType;
    }

    public String getSku_1() {
        return sku_1;
    }

    public void setSku_1(String sku_1) {
        this.sku_1 = sku_1;
    }

    public String getSku_2() {
        return sku_2;
    }

    public void setSku_2(String sku_2) {
        this.sku_2 = sku_2;
    }

    public String getSku_3() {
        return sku_3;
    }

    public void setSku_3(String sku_3) {
        this.sku_3 = sku_3;
    }

}