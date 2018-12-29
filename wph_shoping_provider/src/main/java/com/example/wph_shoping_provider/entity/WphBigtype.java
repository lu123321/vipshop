package com.example.wph_shoping_provider.entity;

import java.io.Serializable;

/**
 * (WphBigtype)实体类
 *
 * @author makejava
 * @since 2018-12-19 09:33:38
 */
public class WphBigtype implements Serializable {
    private static final long serialVersionUID = 281378740199389635L;
    //大类型ID
    private Integer bigtypeId;
    //大类型名称
    private String bigtypeName;
    //大类型状态
    private Integer bigtypeType;
    //冗余列1
    private String bigtype_1;
    //冗余列2
    private String bigtype_2;
    //冗余列3
    private String bigtype_3;


    public Integer getBigtypeId() {
        return bigtypeId;
    }

    public void setBigtypeId(Integer bigtypeId) {
        this.bigtypeId = bigtypeId;
    }

    public String getBigtypeName() {
        return bigtypeName;
    }

    public void setBigtypeName(String bigtypeName) {
        this.bigtypeName = bigtypeName;
    }

    public Integer getBigtypeType() {
        return bigtypeType;
    }

    public void setBigtypeType(Integer bigtypeType) {
        this.bigtypeType = bigtypeType;
    }

    public String getBigtype_1() {
        return bigtype_1;
    }

    public void setBigtype_1(String bigtype_1) {
        this.bigtype_1 = bigtype_1;
    }

    public String getBigtype_2() {
        return bigtype_2;
    }

    public void setBigtype_2(String bigtype_2) {
        this.bigtype_2 = bigtype_2;
    }

    public String getBigtype_3() {
        return bigtype_3;
    }

    public void setBigtype_3(String bigtype_3) {
        this.bigtype_3 = bigtype_3;
    }

}