package com.example.wph_order_provider.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * (WphUserComment)实体类
 *
 * @author makejava
 * @since 2019-01-14 17:03:16
 */
public class WphUserComment implements Serializable {
    private static final long serialVersionUID = -65111866896222590L;

    //评论编号
    private Integer commentId;

    //用户编号
    private Integer commentUserid;

    //商品编号
    private Integer commentSpuid;

    //评论内容
    private String commentContent;

    //评论级别
    private Integer commentGradle;

    //回复
    private String commentHuifu;

    private Date comment_nowtime;

    private Integer comment_orderid;
    private List<Commentimg> clist;

    public List<Commentimg> getClist() {
        return clist;
    }

    public void setClist(List<Commentimg> clist) {
        this.clist = clist;
    }

    public Integer getComment_orderid() {
        return comment_orderid;
    }

    public void setComment_orderid(Integer comment_orderid) {
        this.comment_orderid = comment_orderid;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getCommentUserid() {
        return commentUserid;
    }

    public void setCommentUserid(Integer commentUserid) {
        this.commentUserid = commentUserid;
    }

    public Integer getCommentSpuid() {
        return commentSpuid;
    }

    public void setCommentSpuid(Integer commentSpuid) {
        this.commentSpuid = commentSpuid;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Integer getCommentGradle() {
        return commentGradle;
    }

    public void setCommentGradle(Integer commentGradle) {
        this.commentGradle = commentGradle;
    }

    public String getCommentHuifu() {
        return commentHuifu;
    }

    public void setCommentHuifu(String commentHuifu) {
        this.commentHuifu = commentHuifu;
    }

    public Date getComment_nowtime() {
        return comment_nowtime;
    }

    public void setComment_nowtime(Date comment_nowtime) {
        this.comment_nowtime = comment_nowtime;
    }
}