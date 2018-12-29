package com.example.wph_shoping_provider.entity;

import java.io.Serializable;

/**
 * (WphAttributename)实体类
 *
 * @author makejava
 * @since 2018-12-19 09:31:35
 */

public class WphAttributename implements Serializable {
    private static final long serialVersionUID = -25752849964527266L;
    //属性名ID
    private Integer attributenameId;
    //属性名名称
    private String attributenameName;
    //属性名状态
    private Integer attributenameType;
    //冗余列1
    private String attributename_1;
    //冗余列2
    private String attributename_2;
    //冗余列3
    private String attributename_3;


    public Integer getAttributenameId() {
        return attributenameId;
    }

    public void setAttributenameId(Integer attributenameId) {
        this.attributenameId = attributenameId;
    }

    public String getAttributenameName() {
        return attributenameName;
    }

    public void setAttributenameName(String attributenameName) {
        this.attributenameName = attributenameName;
    }

    public Integer getAttributenameType() {
        return attributenameType;
    }

    public void setAttributenameType(Integer attributenameType) {
        this.attributenameType = attributenameType;
    }

    public String getAttributename_1() {
        return attributename_1;
    }

    public void setAttributename_1(String attributename_1) {
        this.attributename_1 = attributename_1;
    }

    public String getAttributename_2() {
        return attributename_2;
    }

    public void setAttributename_2(String attributename_2) {
        this.attributename_2 = attributename_2;
    }

    public String getAttributename_3() {
        return attributename_3;
    }

    public void setAttributename_3(String attributename_3) {
        this.attributename_3 = attributename_3;
    }

}