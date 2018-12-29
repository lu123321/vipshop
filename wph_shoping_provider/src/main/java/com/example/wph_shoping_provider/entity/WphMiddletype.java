package com.example.wph_shoping_provider.entity;

import com.example.wph_shoping_provider.utilentity.SmallAndMiddle;

import java.io.Serializable;
import java.util.List;

/**
 * (WphMiddletype)实体类
 *
 * @author makejava
 * @since 2018-12-19 09:38:53
 */
public class WphMiddletype implements Serializable {
    private static final long serialVersionUID = -16159158439035477L;
    //中类型id
    private Integer middletypeId;
    //种类型名称
    private String middletypeName;
    //父级id
    private Integer middletypeBigtyprid;
    //状态
    private Integer middletypeType;
    //冗余列1
    private String middletype_1;
    //冗余列2
    private String middletype_2;
    //冗余列3
    private String middletype_3;

    private List<WphSmalltype> smallAndMiddles;

    public List<WphSmalltype> getSmallAndMiddles() {
        return smallAndMiddles;
    }

    public void setSmallAndMiddles(List<WphSmalltype> smallAndMiddles) {
        this.smallAndMiddles = smallAndMiddles;
    }

    public Integer getMiddletypeId() {
        return middletypeId;
    }

    public void setMiddletypeId(Integer middletypeId) {
        this.middletypeId = middletypeId;
    }

    public String getMiddletypeName() {
        return middletypeName;
    }

    public void setMiddletypeName(String middletypeName) {
        this.middletypeName = middletypeName;
    }

    public Integer getMiddletypeBigtyprid() {
        return middletypeBigtyprid;
    }

    public void setMiddletypeBigtyprid(Integer middletypeBigtyprid) {
        this.middletypeBigtyprid = middletypeBigtyprid;
    }

    public Integer getMiddletypeType() {
        return middletypeType;
    }

    public void setMiddletypeType(Integer middletypeType) {
        this.middletypeType = middletypeType;
    }

    public String getMiddletype_1() {
        return middletype_1;
    }

    public void setMiddletype_1(String middletype_1) {
        this.middletype_1 = middletype_1;
    }

    public String getMiddletype_2() {
        return middletype_2;
    }

    public void setMiddletype_2(String middletype_2) {
        this.middletype_2 = middletype_2;
    }

    public String getMiddletype_3() {
        return middletype_3;
    }

    public void setMiddletype_3(String middletype_3) {
        this.middletype_3 = middletype_3;
    }

}