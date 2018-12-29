package com.example.wph_shoping_provider.entity;

import java.io.Serializable;

/**
 * (WphBrand)实体类
 *
 * @author makejava
 * @since 2018-12-19 09:37:15
 */
public class WphBrand implements Serializable {
    private static final long serialVersionUID = -54556309308470559L;
    //品牌ID
    private Integer brandId;
    //品牌名
    private String brandName;
    //品牌描述
    private String brandDescribe;
    //品牌类型
    private Integer brandType;
    //冗余列1
    private String brandSite;
    //冗余列2
    private String brand_1;
    //冗余列3
    private String brand_2;
    
    private String brand_3;



    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandDescribe() {
        return brandDescribe;
    }

    public void setBrandDescribe(String brandDescribe) {
        this.brandDescribe = brandDescribe;
    }

    public Integer getBrandType() {
        return brandType;
    }

    public void setBrandType(Integer brandType) {
        this.brandType = brandType;
    }

    public String getBrandSite() {
        return brandSite;
    }

    public void setBrandSite(String brandSite) {
        this.brandSite = brandSite;
    }

    public String getBrand_1() {
        return brand_1;
    }

    public void setBrand_1(String brand_1) {
        this.brand_1 = brand_1;
    }

    public String getBrand_2() {
        return brand_2;
    }

    public void setBrand_2(String brand_2) {
        this.brand_2 = brand_2;
    }

    public String getBrand_3() {
        return brand_3;
    }

    public void setBrand_3(String brand_3) {
        this.brand_3 = brand_3;
    }

}