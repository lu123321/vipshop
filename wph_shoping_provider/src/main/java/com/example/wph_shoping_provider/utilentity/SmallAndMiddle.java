package com.example.wph_shoping_provider.utilentity;

import com.example.wph_shoping_provider.entity.WphSmalltype;

import java.util.List;

public class SmallAndMiddle {
    private Integer MiddleId;
    private List<WphSmalltype> smalltypes;

    public Integer getMiddleId() {
        return MiddleId;
    }

    public void setMiddleId(Integer middleId) {
        MiddleId = middleId;
    }

    public List<WphSmalltype> getSmalltypes() {
        return smalltypes;
    }

    public void setSmalltypes(List<WphSmalltype> smalltypes) {
        this.smalltypes = smalltypes;
    }
}
