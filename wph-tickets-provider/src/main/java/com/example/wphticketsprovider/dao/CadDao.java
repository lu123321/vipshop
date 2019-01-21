package com.example.wphticketsprovider.dao;


import com.example.wphticketsprovider.entity.Couponsandusers;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CadDao {

    //用户查看所拥有的优惠券
    @Select("select caucid FROM couponsandusers where cauuid =#{cauuid} ORDER BY  caucid asc")
    List<Couponsandusers> getAllCouponsById(Integer cauuid);

    //增加优惠券id和用户id
    @Insert("insert into couponsandusers (caucid,cauuid) VALUES (#{caucid},#{cauuid})")
    int insertCopAndUser(@Param("caucid") Integer caucid,
                         @Param("cauuid") Integer cauuid);

    //删除优惠券id和用户id
    @Delete("delete from couponsandusers where caucid =#{caucid} and cauuid = #{cauuid}")
    int deleteCopAndUser(@Param("caucid") Integer caucid,
                         @Param("cauuid") Integer cauuid);


    //通过优惠券id和用户id查询
    @Select("select * from couponsandusers where caucid = #{caucid} and cauuid = #{cauuid}")
    Couponsandusers   getOneCouponsBy(@Param("caucid") Integer caucid,
                                      @Param("cauuid") Integer cauuid);

    //通过优惠券id查找用户集合
    @Select("select * from couponsandusers where caucid = #{caucid}")
    List<Couponsandusers>  getList(@Param("caucid")Integer caucid);

    //通过优惠券id删除拥有的用户
    @Delete("delete from couponsandusers where caucid = #{caucid}")
    int   deleList(@Param("caucid") Integer caucid);

    //用户通过自己的id查看自己拥有的优惠券
    @Select("SELECT caucid  from couponsandusers  where cauuid = #{cauuid}")
    List<Couponsandusers>  getClistById(@Param("cauuid") Integer cauuid);
}
