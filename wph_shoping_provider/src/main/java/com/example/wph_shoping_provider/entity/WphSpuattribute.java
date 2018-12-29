package com.example.wph_shoping_provider.entity;

import java.io.Serializable;

/**
 * (WphSpuattribute)实体类
 *
 * @author makejava
 * @since 2018-12-19 10:03:14
 */
public class WphSpuattribute implements Serializable {
    private static final long serialVersionUID = 351738848054492240L;
    //产品属性id
    private Integer spuattributeId;
    //产品id
    private Integer spuattributeSpuid;
    //属性名id
    private Integer spuattributeAttributenameid;
    //属性值id
    private Integer spuattributeAttributevalueid;
    //商品id
    private Integer spuattributeSkuid;
    //冗余列1
    private String spuattribute_1;
    //冗余列2
    private String spuattribute_2;
    //冗余列3
    private String spuattribute_3;


    public Integer getSpuattributeId() {
        return spuattributeId;
    }

    public void setSpuattributeId(Integer spuattributeId) {
        this.spuattributeId = spuattributeId;
    }

    public Integer getSpuattributeSpuid() {
        return spuattributeSpuid;
    }

    public void setSpuattributeSpuid(Integer spuattributeSpuid) {
        this.spuattributeSpuid = spuattributeSpuid;
    }

    public Integer getSpuattributeAttributenameid() {
        return spuattributeAttributenameid;
    }

    public void setSpuattributeAttributenameid(Integer spuattributeAttributenameid) {
        this.spuattributeAttributenameid = spuattributeAttributenameid;
    }

    public Integer getSpuattributeAttributevalueid() {
        return spuattributeAttributevalueid;
    }

    public void setSpuattributeAttributevalueid(Integer spuattributeAttributevalueid) {
        this.spuattributeAttributevalueid = spuattributeAttributevalueid;
    }

    public Integer getSpuattributeSkuid() {
        return spuattributeSkuid;
    }

    public void setSpuattributeSkuid(Integer spuattributeSkuid) {
        this.spuattributeSkuid = spuattributeSkuid;
    }

    public String getSpuattribute_1() {
        return spuattribute_1;
    }

    public void setSpuattribute_1(String spuattribute_1) {
        this.spuattribute_1 = spuattribute_1;
    }

    public String getSpuattribute_2() {
        return spuattribute_2;
    }

    public void setSpuattribute_2(String spuattribute_2) {
        this.spuattribute_2 = spuattribute_2;
    }

    public String getSpuattribute_3() {
        return spuattribute_3;
    }

    public void setSpuattribute_3(String spuattribute_3) {
        this.spuattribute_3 = spuattribute_3;
    }

}