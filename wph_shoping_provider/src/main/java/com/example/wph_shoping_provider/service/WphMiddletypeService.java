package com.example.wph_shoping_provider.service;

public interface WphMiddletypeService {
    /**
     * 根据大类型id展示所对应的中类型
     * @param bigpeid
     * @return
     */
    String selectMiddletype(Integer bigpeid);
}
