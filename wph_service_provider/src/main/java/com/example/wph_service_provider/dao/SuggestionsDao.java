package com.example.wph_service_provider.dao;

import com.example.wph_service_provider.entity.Suggestions;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Suggestions)表数据库访问层
 *
 * @author makejava
 * @since 2018-12-19 19:37:55
 */
@Mapper
@Repository
public interface SuggestionsDao {

    /**
     * 新增数据
     *
     * @param suggestions 实例对象
     * @return 影响行数
     */
    int insert(Suggestions suggestions);

    //用户通过id查看自己提交的建议
    //用户通过id和时间查询一下当天提交的次数，防止垃圾信息大量注入
    //用户通过id和提交时间查看自己提交的建议
    //商家通过时间查看用户提交的建议
    //商家通过id查看特定用户提交的建议
    List<Suggestions> queryAll(Suggestions suggestions);

    //用户通过uid和 creatTime 删除自己提交的反馈
    @Delete("delete from suggestions where uid = #{uid} and creatTime = #{creatTime}")
    int deleteSugByUid(@Param("uid") Integer uid,@Param("creatTime") String creatTime);

    //通过主键删除数据
    int deleteById(Integer sugid);

    //查询数据库总条数
    @Select("select count(1) from suggestions")
    int titlePageCount();

    //用户查看提交的反馈
    @Select("select * from suggestions where uid = #{uid} order by sugid DESC")
    List<Suggestions> getAllByUid(@Param("uid") int uid);

    //用户查看自己提交的反馈总条数
    @Select("select count(1) from suggestions where uid = #{uid}")
    int titleCountUser(@Param("uid") Integer uid);


    /**
     * 通过ID查询单条数据
     *
     * @param sugid 主键
     * @return 实例对象
     */
    Suggestions queryById(Integer sugid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Suggestions> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    //用户修改自己提交的反馈
    int update(Suggestions suggestions);

    //用户查询两个时间点之间的数据
    List<Suggestions>  getBetween(@Param("creatTime1") String creatTime1,
                                  @Param("creatTime2")String creatTime2);


}