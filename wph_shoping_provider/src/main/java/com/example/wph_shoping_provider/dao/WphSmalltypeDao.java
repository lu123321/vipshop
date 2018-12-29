package com.example.wph_shoping_provider.dao;

import com.example.wph_shoping_provider.entity.WphSmalltype;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (WphSmalltype)表数据库访问层
 *
 * @author makejava
 * @since 2018-12-19 10:02:53
 */
@Component
public interface WphSmalltypeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param smalltypeId 主键
     * @return 实例对象
     */
    WphSmalltype queryById(Integer smalltypeId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<WphSmalltype> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param wphSmalltype 实例对象
     * @return 对象列表
     */
    List<WphSmalltype> queryAll(WphSmalltype wphSmalltype);

    /**
     * 新增数据
     *
     * @param wphSmalltype 实例对象
     * @return 影响行数
     */
    int insert(WphSmalltype wphSmalltype);

    /**
     * 修改数据
     *
     * @param wphSmalltype 实例对象
     * @return 影响行数
     */
    int update(WphSmalltype wphSmalltype);

    /**
     * 通过主键删除数据
     *
     * @param smalltypeId 主键
     * @return 影响行数
     */
    int deleteById(Integer smalltypeId);

}