package com.example.wph_shoping_provider.dao;

import com.example.wph_shoping_provider.entity.WphMiddletype;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (WphMiddletype)表数据库访问层
 *
 * @author makejava
 * @since 2018-12-19 09:38:53
 */
@Component
public interface WphMiddletypeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param middletypeId 主键
     * @return 实例对象
     */
    WphMiddletype queryById(Integer middletypeId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<WphMiddletype> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param wphMiddletype 实例对象
     * @return 对象列表
     */
    List<WphMiddletype> queryAll(WphMiddletype wphMiddletype);

    /**
     * 新增数据
     *
     * @param wphMiddletype 实例对象
     * @return 影响行数
     */
    int insert(WphMiddletype wphMiddletype);

    /**
     * 修改数据
     *
     * @param wphMiddletype 实例对象
     * @return 影响行数
     */
    int update(WphMiddletype wphMiddletype);

    /**
     * 通过主键删除数据
     *
     * @param middletypeId 主键
     * @return 影响行数
     */
    int deleteById(Integer middletypeId);

}