package com.example.wph_shoping_provider.dao;

import com.example.wph_shoping_provider.entity.WphSmalltypeandbrand;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (WphSmalltypeandbrand)表数据库访问层
 *
 * @author makejava
 * @since 2018-12-19 19:31:58
 */
@Component
public interface WphSmalltypeandbrandDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    WphSmalltypeandbrand queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<WphSmalltypeandbrand> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param wphSmalltypeandbrand 实例对象
     * @return 对象列表
     */
    List<WphSmalltypeandbrand> queryAll(WphSmalltypeandbrand wphSmalltypeandbrand);

    /**
     * 新增数据
     *
     * @param wphSmalltypeandbrand 实例对象
     * @return 影响行数
     */
    int insert(WphSmalltypeandbrand wphSmalltypeandbrand);

    /**
     * 修改数据
     *
     * @param wphSmalltypeandbrand 实例对象
     * @return 影响行数
     */
    int update(WphSmalltypeandbrand wphSmalltypeandbrand);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}