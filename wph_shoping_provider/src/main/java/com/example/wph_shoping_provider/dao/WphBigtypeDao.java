package com.example.wph_shoping_provider.dao;

import com.example.wph_shoping_provider.entity.WphBigtype;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (WphBigtype)表数据库访问层
 *
 * @author makejava
 * @since 2018-12-19 09:33:39
 */
@Component
public interface WphBigtypeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param bigtypeId 主键
     * @return 实例对象
     */
    WphBigtype queryById(Integer bigtypeId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<WphBigtype> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param wphBigtype 实例对象
     * @return 对象列表
     */
    List<WphBigtype> queryAll(WphBigtype wphBigtype);

    /**
     * 新增数据
     *
     * @param wphBigtype 实例对象
     * @return 影响行数
     */
    int insert(WphBigtype wphBigtype);

    /**
     * 修改数据
     *
     * @param wphBigtype 实例对象
     * @return 影响行数
     */
    int update(WphBigtype wphBigtype);

    /**
     * 通过主键删除数据
     *
     * @param bigtypeId 主键
     * @return 影响行数
     */
    int deleteById(Integer bigtypeId);

}