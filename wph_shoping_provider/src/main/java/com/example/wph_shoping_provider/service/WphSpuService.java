package com.example.wph_shoping_provider.service;

import com.example.wph_shoping_provider.entity.WphBrand;
import com.example.wph_shoping_provider.entity.WphSpu;
import org.springframework.data.annotation.Id;

public interface WphSpuService {
    /**
     * 查询产品信息
     * @param spuid 产品id
     * @return
     * @throws Exception
     */
    String wphselectSpuShow(Integer spuid);


    /**
     * 根据小类型查找产品
     * @param smalltypeId
     * @return
     */
    String wphselectSpuAll(Integer smalltypeId,Integer pageNum,Integer pageSize);

    /**
     * 根据品牌Id展示商品
     * @param BranId
     * @return
     */
    String wphBranSpu(Integer BranId,Integer pageNum,Integer pageSize);


    /**
     * 增加一条产品信息
     * @param wphSpu
     * @return
     */
    String insertSpu(WphSpu wphSpu);

    /**
     * 修改产品信息
     * @param wphSpu
     * @return
     */
    String wphUpdataSpuShow(WphSpu wphSpu);

    /**
     *从小到大
     * @return
     */
    String ASCspu(String typeid,String brandid);

    /**
     * 从大到小
     * @return
     */
    String DESCspu(String Id,String brandid);


}
