package com.example.wph_order_provider.entity;

import java.io.Serializable;

/**
 * (Commentimg)实体类
 *
 * @author makejava
 * @since 2019-01-16 11:10:52
 */
public class Commentimg implements Serializable {
    private static final long serialVersionUID = 400067582551785042L;
    
    private Integer imgid;
    
    private Integer commentid;
    
    private String img1;


    public Integer getImgid() {
        return imgid;
    }

    public void setImgid(Integer imgid) {
        this.imgid = imgid;
    }

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

}