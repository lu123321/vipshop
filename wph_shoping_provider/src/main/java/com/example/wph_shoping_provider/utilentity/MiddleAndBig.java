package com.example.wph_shoping_provider.utilentity;

import com.example.wph_shoping_provider.entity.WphMiddletype;
import com.example.wph_shoping_provider.entity.WphSmalltype;

import javax.validation.constraints.Null;
import java.util.List;

public class MiddleAndBig {
    private Integer bigTypeId;

    private List<WphMiddletype> middletypes;

    public Integer getBigTypeId() {
        return bigTypeId;
    }

    public void setBigTypeId(Integer bigTypeId) {
        this.bigTypeId = bigTypeId;
    }



    public List<WphMiddletype> getMiddletypes() {
        return middletypes;
    }

    public void setMiddletypes(List<WphMiddletype> middletypes) {
        this.middletypes = middletypes;
    }
}
