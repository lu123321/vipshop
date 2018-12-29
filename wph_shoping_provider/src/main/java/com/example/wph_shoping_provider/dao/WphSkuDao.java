package com.example.wph_shoping_provider.dao;

import com.example.wph_shoping_provider.entity.WphSku;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (WphSku)表数据库访问层
 *
 * @author makejava
 * @since 2018-12-19 09:33:38
 */
@Component
public interface WphSkuDao {

    /**
     * 通过ID查询单条数据
     *
     * @param skuId 主键
     * @return 实例对象
     */
    WphSku queryById(Integer skuId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<WphSku> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param wphSku 实例对象
     * @return 对象列表
     */
    List<WphSku> queryAll(WphSku wphSku);

    /**
     * 新增数据
     *
     * @param wphSku 实例对象
     * @return 影响行数
     */
    int insert(WphSku wphSku);

    /**
     * 修改数据
     *
     * @param wphSku 实例对象
     * @return 影响行数
     */
    int update(WphSku wphSku);

    /**
     * 通过主键删除数据
     *
     * @param skuId 主键
     * @return 影响行数
     */
    int deleteById(Integer skuId);

}