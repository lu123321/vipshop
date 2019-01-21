package com.example.wph_service_provider.dao;

import com.example.wph_service_provider.entity.Customerservice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Customerservice)表数据库访问层
 *
 * @author makejava
 * @since 2018-12-20 14:18:52
 */
@Repository
@Mapper
public interface CustomerserviceDao {

    //通过问题类型查找具体的问题
    @Select("select  csquestion,csid from customerservice  where cstype = #{cstype}")
    List<Customerservice>  findQuestionByType(String cstype);


    //通过具体问题找解决方案
    @Select("select cssolution from customerservice where csquestion = #{csquestion};")
    Customerservice  findSolutionByQuestion(String csquestion);
    /**
     * 通过ID查询单条数据
     *
     * @param csid 主键
     * @return 实例对象
     */
    Customerservice queryById(Integer csid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Customerservice> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param customerservice 实例对象
     * @return 对象列表
     */
    List<Customerservice> queryAll(Customerservice customerservice);

    /**
     * 新增数据
     *
     * @param customerservice 实例对象
     * @return 影响行数
     */
    int insert(Customerservice customerservice);

    /**
     * 修改数据
     *
     * @param customerservice 实例对象
     * @return 影响行数
     */
    int update(Customerservice customerservice);

    /**
     * 通过主键删除数据
     *
     * @param csid 主键
     * @return 影响行数
     */
    int deleteById(Integer csid);

}