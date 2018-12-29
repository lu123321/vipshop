package com.example.wph_shopcar_consumer.pojo;

import java.io.Serializable;

/**
 * (WphUserAddress)实体类
 *
 * @author makejava
 * @since 2018-12-21 09:47:27
 */
public class WphUserAddress implements Serializable {
    private static final long serialVersionUID = 253498184802916506L;

    //地址编号
    private Integer addId;

    //用户编号
    private Integer userId;

    //用户姓名
    private String addName;

    //省
    private String addProvince;

    //市
    private String addCity;

    //区
    private String addDistrict;

    //详细地址
    private String addAddress;

    //联系电话
    private String addPhone;

    //备用电话
    private String addNumber;

    //冗余列1
    private String redundancy1;
    //冗余列2
    private String redundancy2;
    //冗余列3
    private String redundancy3;


    public Integer getAddId() {
        return addId;
    }

    public void setAddId(Integer addId) {
        this.addId = addId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAddName() {
        return addName;
    }

    public void setAddName(String addName) {
        this.addName = addName;
    }

    public String getAddProvince() {
        return addProvince;
    }

    public void setAddProvince(String addProvince) {
        this.addProvince = addProvince;
    }

    public String getAddCity() {
        return addCity;
    }

    public void setAddCity(String addCity) {
        this.addCity = addCity;
    }

    public String getAddDistrict() {
        return addDistrict;
    }

    public void setAddDistrict(String addDistrict) {
        this.addDistrict = addDistrict;
    }

    public String getAddAddress() {
        return addAddress;
    }

    public void setAddAddress(String addAddress) {
        this.addAddress = addAddress;
    }

    public String getAddPhone() {
        return addPhone;
    }

    public void setAddPhone(String addPhone) {
        this.addPhone = addPhone;
    }

    public String getAddNumber() {
        return addNumber;
    }

    public void setAddNumber(String addNumber) {
        this.addNumber = addNumber;
    }

    public String getRedundancy1() {
        return redundancy1;
    }

    public void setRedundancy1(String redundancy1) {
        this.redundancy1 = redundancy1;
    }

    public String getRedundancy2() {
        return redundancy2;
    }

    public void setRedundancy2(String redundancy2) {
        this.redundancy2 = redundancy2;
    }

    public String getRedundancy3() {
        return redundancy3;
    }

    public void setRedundancy3(String redundancy3) {
        this.redundancy3 = redundancy3;
    }

}