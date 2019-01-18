package com.example.wph_shopcar_provider.srvice;


import com.example.wph_shopcar_provider.pojo.WphSku;

import java.util.List;
import java.util.Map;

public interface ShopcarService {
    String wph_shopcart_add(String listnumber);
    void wph_shopcart_del(Integer userid,String skuserialnumber);
    void wph_shopcart_update(Integer userid,String shoping);
    Map wph_shopcart_sel(Integer id);
    Map wph_shophistroy_sel(Integer id);
    void del(Integer userid);
    Integer selchopingnum(Integer userid);
}
