package com.example.wph_shoping_provider.dao;

import com.example.wph_shoping_provider.entity.WphAttributename;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (WphAttributename)表数据库访问层
 *
 * @author makejava
 * @since 2018-12-19 09:31:36
 */
@Component
public interface WphAttributenameDao {

    /**
     * 通过ID查询单条数据
     *
     * @param attributenameId 主键
     * @return 实例对象
     */
    WphAttributename queryById(Integer attributenameId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<WphAttributename> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param wphAttributename 实例对象
     * @return 对象列表
     */
    List<WphAttributename> queryAll(WphAttributename wphAttributename);

    /**
     * 新增数据
     *
     * @param wphAttributename 实例对象
     * @return 影响行数
     */
    int insert(WphAttributename wphAttributename);

    /**
     * 修改数据
     *
     * @param wphAttributename 实例对象
     * @return 影响行数
     */
    int update(WphAttributename wphAttributename);

    /**
     * 通过主键删除数据
     *
     * @param attributenameId 主键
     * @return 影响行数
     */
    int deleteById(Integer attributenameId);

}