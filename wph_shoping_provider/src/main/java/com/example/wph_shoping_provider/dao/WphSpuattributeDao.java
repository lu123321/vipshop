package com.example.wph_shoping_provider.dao;

import com.example.wph_shoping_provider.entity.WphSpuattribute;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (WphSpuattribute)表数据库访问层
 *
 * @author makejava
 * @since 2018-12-19 10:03:14
 */
@Component
public interface WphSpuattributeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param spuattributeId 主键
     * @return 实例对象
     */
    WphSpuattribute queryById(Integer spuattributeId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<WphSpuattribute> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param wphSpuattribute 实例对象
     * @return 对象列表
     */
    List<WphSpuattribute> queryAll(WphSpuattribute wphSpuattribute);

    /**
     * 新增数据
     *
     * @param wphSpuattribute 实例对象
     * @return 影响行数
     */
    int insert(WphSpuattribute wphSpuattribute);

    /**
     * 修改数据
     *
     * @param wphSpuattribute 实例对象
     * @return 影响行数
     */
    int update(WphSpuattribute wphSpuattribute);

    /**
     * 通过主键删除数据
     *
     * @param spuattributeId 主键
     * @return 影响行数
     */
    int deleteById(Integer spuattributeId);

}