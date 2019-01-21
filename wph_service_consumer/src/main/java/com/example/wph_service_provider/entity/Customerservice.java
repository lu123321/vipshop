package com.example.wph_service_provider.entity;

import java.io.Serializable;

/**
 * (Customerservice)实体类
 *
 * @author makejava
 * @since 2018-12-20 14:18:52
 */
public class Customerservice implements Serializable {
    private static final long serialVersionUID = 727472697718897988L;
    
    private Integer csid;
    
    private String cstype;              //问题类型

    private String csquestion;         //具体问题

    private String cssolution;         //解决方案


    public Integer getCsid() {
        return csid;
    }

    public void setCsid(Integer csid) {
        this.csid = csid;
    }

    public String getCstype() {
        return cstype;
    }

    public void setCstype(String cstype) {
        this.cstype = cstype;
    }

    public String getCsquestion() {
        return csquestion;
    }

    public void setCsquestion(String csquestion) {
        this.csquestion = csquestion;
    }

    public String getCssolution() {
        return cssolution;
    }

    public void setCssolution(String cssolution) {
        this.cssolution = cssolution;
    }

}