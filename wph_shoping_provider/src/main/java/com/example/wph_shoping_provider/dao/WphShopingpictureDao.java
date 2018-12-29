package com.example.wph_shoping_provider.dao;

import com.example.wph_shoping_provider.entity.WphShopingpicture;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (WphShopingpicture)表数据库访问层
 *
 * @author makejava
 * @since 2018-12-19 10:02:16
 */
@Component
public interface WphShopingpictureDao {

    /**
     * 通过ID查询单条数据
     *
     * @param pictureId 主键
     * @return 实例对象
     */
    WphShopingpicture queryById(Integer pictureId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<WphShopingpicture> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param wphShopingpicture 实例对象
     * @return 对象列表
     */
    List<WphShopingpicture> queryAll(WphShopingpicture wphShopingpicture);

    /**
     * 新增数据
     *
     * @param wphShopingpicture 实例对象
     * @return 影响行数
     */
    int insert(WphShopingpicture wphShopingpicture);

    /**
     * 修改数据
     *
     * @param wphShopingpicture 实例对象
     * @return 影响行数
     */
    int update(WphShopingpicture wphShopingpicture);

    /**
     * 通过主键删除数据
     *
     * @param pictureId 主键
     * @return 影响行数
     */
    int deleteById(Integer pictureId);

}