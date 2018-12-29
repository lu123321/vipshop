package com.example.wph_shoping_provider.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (WphSpu)实体类
 *
 * @author makejava
 * @since 2018-12-19 09:33:37
 */
public class WphSpu implements Serializable {
    private static final long serialVersionUID = 359230797717252899L;
    //产品ID
    private Integer spuId;
    //产品名称
    private String spuName;
    //产品品牌id
    private Integer spuBrandid;
    //产品显示价格
    private Double spuListmoney;
    //产品原价格
    private Double spuOriginalmoney;

    public Double getSpuOriginalmoney() {
        return spuOriginalmoney;
    }

    public void setSpuOriginalmoney(Double spuOriginalmoney) {
        this.spuOriginalmoney = spuOriginalmoney;
    }

    public Double getSpuListmoney() {
        return spuListmoney;
    }

    public void setSpuListmoney(Double spuListmoney) {
        this.spuListmoney = spuListmoney;
    }

    //产品状态
    private Integer spuType;
    //产品详情
    private String spuDetails;
    //产品上架时间
    private Date spuAddtime;
    //产品下架时间
    private Date spuUndertime;
    //产品所属类型
    private Integer spuSmalltypeId;

    public Integer getSpuSmalltypeId() {
        return spuSmalltypeId;
    }

    public void setSpuSmalltypeId(Integer spuSmalltypeId) {
        this.spuSmalltypeId = spuSmalltypeId;
    }

    //冗余列1
    private String spu_1;
    //冗余列2
    private String spu_2;
    //冗余列3
    private String spu_3;


    public Integer getSpuId() {
        return spuId;
    }

    public void setSpuId(Integer spuId) {
        this.spuId = spuId;
    }

    public String getSpuName() {
        return spuName;
    }

    public void setSpuName(String spuName) {
        this.spuName = spuName;
    }

    public Integer getSpuBrandid() {
        return spuBrandid;
    }

    public void setSpuBrandid(Integer spuBrandid) {
        this.spuBrandid = spuBrandid;
    }


    public Integer getSpuType() {
        return spuType;
    }

    public void setSpuType(Integer spuType) {
        this.spuType = spuType;
    }

    public String getSpuDetails() {
        return spuDetails;
    }

    public void setSpuDetails(String spuDetails) {
        this.spuDetails = spuDetails;
    }

    public Date getSpuAddtime() {
        return spuAddtime;
    }

    public void setSpuAddtime(Date spuAddtime) {
        this.spuAddtime = spuAddtime;
    }

    public Date getSpuUndertime() {
        return spuUndertime;
    }

    public void setSpuUndertime(Date spuUndertime) {
        this.spuUndertime = spuUndertime;
    }

    public String getSpu_1() {
        return spu_1;
    }

    public void setSpu_1(String spu_1) {
        this.spu_1 = spu_1;
    }

    public String getSpu_2() {
        return spu_2;
    }

    public void setSpu_2(String spu_2) {
        this.spu_2 = spu_2;
    }

    public String getSpu_3() {
        return spu_3;
    }

    public void setSpu_3(String spu_3) {
        this.spu_3 = spu_3;
    }

}