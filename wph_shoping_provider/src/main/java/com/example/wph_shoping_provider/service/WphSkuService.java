package com.example.wph_shoping_provider.service;

import com.example.wph_shoping_provider.entity.WphSku;

public interface WphSkuService {
    /**
     * 提供给购物车的sku数据
     * @param skuSerialnumber
     * @return
     */
    String WphSeleteSku(String skuSerialnumber,Integer shopingNumber);

    /**
     * 提供给秒杀的Sku数据,并添加到购物车
     * @param skuSerialnumber 商品编号
     * @return
     */
    String WphSelectku(String skuSerialnumber,Integer shopingNumber);

    /**
     * 根据品牌Id查找商品
     * @param BrandSku
     * @return
     */
    String BrandSku(String BrandSku,String time);

    /**
     * 下架品牌并修改数量
     * @param SkuSerialnimber
     * @return
     */
    String xiajiaBrand(String SkuSerialnimber);

    /**
     * 修改Sku信息
     */
    String UpdateSku(WphSku wphSku);

    /**
     * 增加一条商品信息
     * @param wphSku
     * @return
     */
    String insterSku(WphSku wphSku);

}
