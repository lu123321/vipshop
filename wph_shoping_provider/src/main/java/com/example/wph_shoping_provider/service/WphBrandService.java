package com.example.wph_shoping_provider.service;

import com.example.wph_shoping_provider.entity.WphBrand;
import com.example.wph_shoping_provider.entity.WphSmalltype;

public interface WphBrandService {
    /**
     * 根据品牌id查询品牌
     * @param wphBrandId
     * @return
     */
    String selectBrandAll(Integer wphBrandId);

    /**
     * 根据类型Id查询品牌
     * @return
     */
    String selectTypeBrandAll(Integer typeId);

    /**
     * 修改品牌信息
     * @param wphBrand
     * @return
     */
    String updateBrand(WphBrand wphBrand);

    /**
     * 增加一条品牌信息
     * @param wphBrand
     * @return
     */
    String insertBrand(WphBrand wphBrand);
}
