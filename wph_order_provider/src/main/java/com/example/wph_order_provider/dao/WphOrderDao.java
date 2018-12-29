package com.example.wph_order_provider.dao;

import com.example.wph_order_provider.entity.WphOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * (WphOrder)表数据库访问层
 *
 * @author makejava
 * @since 2018-12-19 09:15:12
 */
@Component
public interface WphOrderDao {

    /**
     * 通过ID查询单条数据
     *
     * @param orderid 主键
     * @return 实例对象
     */
    WphOrder queryById(@Param("orderid") Integer orderid);

    /**
     * 通过用户id作为筛选条件查询
     *
     * @param userid 用户id
     * @return 对象列表
     */
    List<WphOrder> queryAll(@Param("userid")Integer userid);

    /**
     * 新增订单
     * @param wphOrder
     * @return
     */
    int insert(WphOrder wphOrder);

    /**
     * 修改数据
     *
     * @param orderno 订单编号
     * @return 影响行数
     */
    int update(@Param("orderno")String orderno,@Param("orderState")Integer orderState,@Param("orderpaynumber")String orderpaynumber);

    /**
     * 通过主键删除数据
     *
     * @param orderid 主键
     * @return 影响行数
     */
    int deleteById(@Param("orderid")Integer orderid);

    /**
     * 通过订单编号查订单id
     * @param orderno 订单编号查询
     * @return 订单id
     */
    Integer selbyno(@Param("orderno") String orderno);

    /**
     * 后台查看订单状态
     * @return
     */
    List<WphOrder> selstate();

    /**
     * 后台发货
     * @return
     */
    int updatestate(@Param("userid")Integer userid,@Param("orderwaybill")String orderwaybill,@Param("orderid") Integer orderid);
}