package com.example.wph_shoping_provider.entity;

import java.io.Serializable;

/**
 * (WphAttributevalue)实体类
 *
 * @author makejava
 * @since 2018-12-19 09:33:40
 */
public class WphAttributevalue implements Serializable {
    private static final long serialVersionUID = -96999435368431553L;
    //属性值id
    private Integer attributevalueId;
    //属性值名称
    private String attributevalueName;
    //属性值所属属性名id
    private Integer attributevalueAttributenameid;
    //属性值状态
    private Integer attributevalueType;
    //冗余列1
    private String attributevalue_1;
    //冗余列2
    private String attributevalue_2;
    //冗余列3
    private String attributevalue_3;


    public Integer getAttributevalueId() {
        return attributevalueId;
    }

    public void setAttributevalueId(Integer attributevalueId) {
        this.attributevalueId = attributevalueId;
    }

    public String getAttributevalueName() {
        return attributevalueName;
    }

    public void setAttributevalueName(String attributevalueName) {
        this.attributevalueName = attributevalueName;
    }

    public Integer getAttributevalueAttributenameid() {
        return attributevalueAttributenameid;
    }

    public void setAttributevalueAttributenameid(Integer attributevalueAttributenameid) {
        this.attributevalueAttributenameid = attributevalueAttributenameid;
    }

    public Integer getAttributevalueType() {
        return attributevalueType;
    }

    public void setAttributevalueType(Integer attributevalueType) {
        this.attributevalueType = attributevalueType;
    }

    public String getAttributevalue_1() {
        return attributevalue_1;
    }

    public void setAttributevalue_1(String attributevalue_1) {
        this.attributevalue_1 = attributevalue_1;
    }

    public String getAttributevalue_2() {
        return attributevalue_2;
    }

    public void setAttributevalue_2(String attributevalue_2) {
        this.attributevalue_2 = attributevalue_2;
    }

    public String getAttributevalue_3() {
        return attributevalue_3;
    }

    public void setAttributevalue_3(String attributevalue_3) {
        this.attributevalue_3 = attributevalue_3;
    }

}