package com.example.wph_shoping_provider.entity;

import java.io.Serializable;

/**
 * (WphShopingpicture)实体类
 *
 * @author makejava
 * @since 2018-12-19 10:02:16
 */
public class WphShopingpicture implements Serializable {
    private static final long serialVersionUID = 671753749201753673L;
    //图片ID
    private Integer pictureId;
    //图片地址
    private String pictureAddress;
    //冗余列1
    private String picture_1;


    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }

    public String getPictureAddress() {
        return pictureAddress;
    }

    public void setPictureAddress(String pictureAddress) {
        this.pictureAddress = pictureAddress;
    }

    public String getPicture_1() {
        return picture_1;
    }

    public void setPicture_1(String picture_1) {
        this.picture_1 = picture_1;
    }

}