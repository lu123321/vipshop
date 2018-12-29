package com.example.wph_shoping_provider.dao;

import com.example.wph_shoping_provider.entity.WphAttributevalue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (WphAttributevalue)表数据库访问层
 *
 * @author makejava
 * @since 2018-12-19 09:33:40
 */
@Component
public interface WphAttributevalueDao {

    /**
     * 通过ID查询单条数据
     *
     * @param attributevalueId 主键
     * @return 实例对象
     */
    WphAttributevalue queryById(Integer attributevalueId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<WphAttributevalue> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param wphAttributevalue 实例对象
     * @return 对象列表
     */
    List<WphAttributevalue> queryAll(WphAttributevalue wphAttributevalue);

    /**
     * 新增数据
     *
     * @param wphAttributevalue 实例对象
     * @return 影响行数
     */
    int insert(WphAttributevalue wphAttributevalue);

    /**
     * 修改数据
     *
     * @param wphAttributevalue 实例对象
     * @return 影响行数
     */
    int update(WphAttributevalue wphAttributevalue);

    /**
     * 通过主键删除数据
     *
     * @param attributevalueId 主键
     * @return 影响行数
     */
    int deleteById(Integer attributevalueId);

}