package com.example.wph_service_provider.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Suggestions)实体类
 *
 * @author makejava
 * @since 2018-12-19 19:37:54
 */
public class Suggestions implements Serializable {
    private static final long serialVersionUID = 875476036428375474L;
    
    private Integer sugid;
    //反馈类型
    private String sugtype;
    //标题
    private String sugtitle;
    //反馈内容
    private String sugcontent;
    //邮箱/手机号
    private String sugemail;
    //用户id
    private  Integer uid;
    //提交时间
    private String creatTime;
    //状态   0代表未回复   1代表已回复
    private Integer c1;
//    //冗余列
//    private String c2;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public Integer getC1() {
        return c1;
    }

    public void setC1(Integer c1) {
        this.c1 = c1;
    }

//
//    public String getC2() {
//        return c2;
//    }
//
//    public void setC2(String c2) {
//        this.c2 = c2;
//    }

    public Integer getSugid() {
        return sugid;
    }

    public void setSugid(Integer sugid) {
        this.sugid = sugid;
    }

    public String getSugtype() {
        return sugtype;
    }

    public void setSugtype(String sugtype) {
        this.sugtype = sugtype;
    }

    public String getSugtitle() {
        return sugtitle;
    }

    public void setSugtitle(String sugtitle) {
        this.sugtitle = sugtitle;
    }

    public String getSugcontent() {
        return sugcontent;
    }

    public void setSugcontent(String sugcontent) {
        this.sugcontent = sugcontent;
    }

    public String getSugemail() {
        return sugemail;
    }

    public void setSugemail(String sugemail) {
        this.sugemail = sugemail;
    }

}