package com.example.wph_order_provider.service;

import com.example.wph_order_provider.entity.WphOrderShoping;
import java.util.List;

/**
 * (WphOrderShoping)表服务接口
 *
 * @author makejava
 * @since 2018-12-20 11:55:39
 */
public interface WphOrderShopingService {

    /**
     * 新增订单商品
     * @param orderid 订单id
     * @param skuSerialnumber 商品编号
     * @param num 商品数量
     * @return
     */
    int insert(Integer orderid,String skuSerialnumber,Integer num,Integer money);


    /**
     * 通过主键删除数据
     *
     * @param orderShopingId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer orderShopingId,Integer userid);

    /**
     * 根据id查
     * @param orderid
     * @return
     */
    List<WphOrderShoping> queryAll(Integer orderid);
}