package com.example.wph_order_provider.service;

import com.example.wph_order_provider.entity.OrderShoping;
import com.example.wph_order_provider.entity.WphOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (WphOrder)表服务接口
 *
 * @author makejava
 * @since 2018-12-19 09:15:12
 */
public interface WphOrderService {

    /**
     * 通过ID查询单条数据
     *
     * @param orderid 主键
     * @return 实例对象
     */
    List<OrderShoping> queryById(Integer orderid);


    /**
     * 新增订单
     * @param id 用户id
     * @param ordershoping 商品编号
     * @param money 总价
     */
    void insert(Integer id,String ordershoping,Integer money,String orderadress);


    /**
     * 修改数据
     *
     * @param orderno 订单编号
     * @param orderState
     * @return 实例对象
     */
    String update(String orderno,Integer orderState,String orderpaynumber);


    /**
     * 通过主键删除数据
     *
     * @param orderId 主键
     * @return 是否成功
     */
    void deleteById(Integer orderId);

    /**
     * 查全部订单
     * @return
     */
    List queryAll(Integer userid,Integer pagenum);
    /**
     * 后台查看订单状态
     * @return
     */
    List<WphOrder> selstate();

    /**
     * 后台发货
     * @return
     */
    int updatestate(Integer userid, Integer orderid);
}