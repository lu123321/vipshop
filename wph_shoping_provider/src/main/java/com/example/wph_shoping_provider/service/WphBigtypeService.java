package com.example.wph_shoping_provider.service;

import com.example.wph_shoping_provider.entity.WphBigtype;

public interface WphBigtypeService {
    /**
     * 展示全部大类型
     * @return
     */
    String selectBigtype();

    /**
     * 增加一条商品类型
     * @param wphBigtype
     * @return
     */
    String insetBigtype(WphBigtype wphBigtype);

    /**
     * 删除一个类型
     * @param bigTypeId
     * @return
     */
    String delBigtype(Integer bigTypeId);
}
