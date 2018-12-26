package com.example.wph_seckill_provider.service;

public interface CutRepertoryService {
    /**
     * 通过商品编号和商品数量进行库存锁定
     * @param productId
     * @param number
     * @return
     */
    String cutrepertory(String pinpaiId,String productId,String number);

    /**
     * 通过品牌订单和商品信息来进行商品的上架
     * @param brandId
     * @param message
     * @return
     */
    String addRepertory(String brandId,String message);

    /**
     * 通过品牌Id将有关品牌的商品移出redis
     * @param brandId
     * @return
     */
    String removeRepertory(String brandId);


}
