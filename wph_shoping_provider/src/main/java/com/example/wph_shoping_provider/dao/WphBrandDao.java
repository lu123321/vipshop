package com.example.wph_shoping_provider.dao;

import com.example.wph_shoping_provider.entity.WphBrand;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (WphBrand)表数据库访问层
 *
 * @author makejava
 * @since 2018-12-19 09:37:15
 */
@Component
public interface WphBrandDao {

    /**
     * 通过ID查询单条数据
     *
     * @param brandId 主键
     * @return 实例对象
     */
    WphBrand queryById(Integer brandId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<WphBrand> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param wphBrand 实例对象
     * @return 对象列表
     */
    List<WphBrand> queryAll(WphBrand wphBrand);

    /**
     * 新增数据
     *
     * @param wphBrand 实例对象
     * @return 影响行数
     */
    int insert(WphBrand wphBrand);

    /**
     * 修改数据
     *
     * @param wphBrand 实例对象
     * @return 影响行数
     */
    int update(WphBrand wphBrand);

    /**
     * 通过主键删除数据
     *
     * @param brandId 主键
     * @return 影响行数
     */
    int deleteById(Integer brandId);

}