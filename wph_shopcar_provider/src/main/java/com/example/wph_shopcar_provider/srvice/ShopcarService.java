package com.example.wph_shopcar_provider.srvice;


import com.example.wph_shopcar_provider.pojo.WphSku;

import java.util.List;
import java.util.Map;

public interface ShopcarService {
    String wph_shopcart_add(String listnumber,Integer userid);
    void wph_shopcart_del(String userid,String skuserialnumber);
    void wph_shopcart_update(Integer userid,String shoping);
    Map wph_shopcart_sel(String id);
    Map wph_shophistroy_sel(String id);
}
