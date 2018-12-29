package com.example.wph_shoping_provider.dao;

import com.example.wph_shoping_provider.entity.WphSpu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (WphSpu)表数据库访问层
 *
 * @author makejava
 * @since 2018-12-19 09:33:37
 */
@Component
public interface WphSpuDao {

    /**
     * 通过ID查询单条数据
     *
     * @param spuId 主键
     * @return 实例对象
     */
    WphSpu queryById(Integer spuId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<WphSpu> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param wphSpu 实例对象
     * @return 对象列表
     */
    List<WphSpu> queryAll(WphSpu wphSpu);

    /**
     * 新增数据
     *
     * @param wphSpu 实例对象
     * @return 影响行数
     */
    int insert(WphSpu wphSpu);

    /**
     * 修改数据
     *
     * @param wphSpu 实例对象
     * @return 影响行数
     */
    int update(WphSpu wphSpu);

    /**
     * 通过主键删除数据
     *
     * @param spuId 主键
     * @return 影响行数
     */
    int deleteById(Integer spuId);

    /**
     * 从小到da
     * @param wphSpu
     * @return
     */
    List<WphSpu> ASC(WphSpu wphSpu);

    /**
     * 从大到小
     * @param wphSpu
     * @return
     */
    List<WphSpu> DESC(WphSpu wphSpu);

}