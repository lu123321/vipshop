package com.example.wph_shoping_provider.service;

import com.example.wph_shoping_provider.entity.WphSmalltype;

public interface WphSmalltypeService {
    /**
     * 根据中类型id展示所对应的小类型
     * @param middletypeid
     * @return
     */
    String selectSmalltypr(Integer middletypeid);

    /**
     * 增加一条小类型
     * @param wphSmalltype
     * @return
     */
    String insertSmalltype(WphSmalltype wphSmalltype);

    /**
     * 修改小类型信息
      * @return
     */
    String updataSmalltype(WphSmalltype wphSmalltype);
}
