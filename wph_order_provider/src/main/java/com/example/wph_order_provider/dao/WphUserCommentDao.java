package com.example.wph_order_provider.dao;

import com.example.wph_order_provider.entity.WphUserComment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface WphUserCommentDao {
    List queryAllByshoping(@Param("spuid") Integer spuid);

    List queryAllByshoping1(@Param("spuid") Integer spuid);

    List queryAllByshoping2(@Param("spuid") Integer spuid);

    List queryAllByshoping3(@Param("spuid") Integer spuid);

    List hqueryAllByshoping();

    Integer updatecomment(@Param("commentHuifu")String commentHuifu,@Param("commentId")Integer commentId);

    Integer insertcomment(WphUserComment wphUserComment);

    Integer deleteBycommentId(@Param("commentId")Integer commentId);

    Integer queryid(@Param("spuid")Integer spuid,@Param("userid") Integer userid,@Param("orderid")Integer orderid);

    Integer querycount(@Param("spuid")Integer spuid);
    Integer querycount1(@Param("spuid")Integer spuid);
    Integer querycount2(@Param("spuid")Integer spuid);
    Integer querycount3(@Param("spuid")Integer spuid);

}
