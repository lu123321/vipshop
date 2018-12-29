package com.example.wph_shoping_provider.entity;

import java.io.Serializable;

/**
 * (WphSmalltype)实体类
 *
 * @author makejava
 * @since 2018-12-19 10:02:53
 */
public class WphSmalltype implements Serializable {
    private static final long serialVersionUID = 748940195365054682L;
    //小类型ID
    private Integer smalltypeId;
    //小类型名称
    private String smalltypeName;
    //所属父类id
    private Integer smalltypeMiddletypeid;
    //小类型状态
    private Integer smalltypeType;
    //冗余列1
    private String smalltype_1;
    //冗余列2
    private String smalltype_2;
    //冗余列3
    private String smalltype_3;


    public Integer getSmalltypeId() {
        return smalltypeId;
    }

    public void setSmalltypeId(Integer smalltypeId) {
        this.smalltypeId = smalltypeId;
    }

    public String getSmalltypeName() {
        return smalltypeName;
    }

    public void setSmalltypeName(String smalltypeName) {
        this.smalltypeName = smalltypeName;
    }

    public Integer getSmalltypeMiddletypeid() {
        return smalltypeMiddletypeid;
    }

    public void setSmalltypeMiddletypeid(Integer smalltypeMiddletypeid) {
        this.smalltypeMiddletypeid = smalltypeMiddletypeid;
    }

    public Integer getSmalltypeType() {
        return smalltypeType;
    }

    public void setSmalltypeType(Integer smalltypeType) {
        this.smalltypeType = smalltypeType;
    }

    public String getSmalltype_1() {
        return smalltype_1;
    }

    public void setSmalltype_1(String smalltype_1) {
        this.smalltype_1 = smalltype_1;
    }

    public String getSmalltype_2() {
        return smalltype_2;
    }

    public void setSmalltype_2(String smalltype_2) {
        this.smalltype_2 = smalltype_2;
    }

    public String getSmalltype_3() {
        return smalltype_3;
    }

    public void setSmalltype_3(String smalltype_3) {
        this.smalltype_3 = smalltype_3;
    }

}