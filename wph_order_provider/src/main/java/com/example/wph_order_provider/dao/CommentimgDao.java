package com.example.wph_order_provider.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CommentimgDao {
    List queryById(@Param("commentid") Integer commentid);
    int insert(@Param("commentid") Integer commentid,@Param("img1")String img1);
}
