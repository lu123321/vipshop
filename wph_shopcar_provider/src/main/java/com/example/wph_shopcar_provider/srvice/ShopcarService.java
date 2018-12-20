package com.example.wph_shopcar_provider.srvice;


import com.example.wph_shopcar_provider.pojo.WphSku;

import java.util.List;
import java.util.Map;

public interface ShopcarService {
    void wph_shopcart_add(String id,int num);
    void wph_shopcart_del(String id);
    void wph_shopcart_update(String id,int num);
    Map wph_shopcart_sel(String id);

}
