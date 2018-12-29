package com.example.wph_order_provider.dao;

import com.example.wph_order_provider.entity.WphOrderShoping;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * (WphOrderShoping)表数据库访问层
 *
 * @author makejava
 * @since 2018-12-20 11:55:39
 */
@Component
public interface WphOrderShopingDao {


    /**
     * 通过实体作为筛选条件查询
     *
     * @param orderid 实例对象
     * @return 对象列表
     */
    List<WphOrderShoping> queryAll(@Param("orderid") Integer orderid);


    /**
     * 新增订单商品
     * @param orderid 订单id
     * @param skuSerialnumber 商品编号
     * @param num 商品数量
     * @return
     */
    int insert(@Param("orderid") Integer orderid,@Param("skuSerialnumber")String skuSerialnumber,@Param("num")Integer num,@Param("money") Integer money);


    /**
     * 通过主键删除数据
     *
     * @param orderid 主键
     * @return 影响行数
     */
    int deleteById(@Param("orderid") Integer orderid);

}