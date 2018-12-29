package com.example.wph_shoping_provider.entity;

import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * (WphSmalltypeandbrand)实体类
 *
 * @author makejava
 * @since 2018-12-19 19:31:58
 */
@Service
public class WphSmalltypeandbrand implements Serializable {
    private static final long serialVersionUID = 128871981453204770L;
    
    private Integer id;
    
    private Integer sandbAmalltypeid;
    
    private Integer sandbBrandid;
    
    private String sand_1;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSandbAmalltypeid() {
        return sandbAmalltypeid;
    }

    public void setSandbAmalltypeid(Integer sandbAmalltypeid) {
        this.sandbAmalltypeid = sandbAmalltypeid;
    }

    public Integer getSandbBrandid() {
        return sandbBrandid;
    }

    public void setSandbBrandid(Integer sandbBrandid) {
        this.sandbBrandid = sandbBrandid;
    }

    public String getSand_1() {
        return sand_1;
    }

    public void setSand_1(String sand_1) {
        this.sand_1 = sand_1;
    }

}