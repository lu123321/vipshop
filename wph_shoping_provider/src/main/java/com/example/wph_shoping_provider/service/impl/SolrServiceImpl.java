package com.example.wph_shoping_provider.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.wph_shoping_provider.dao.WphShopingpictureDao;
import com.example.wph_shoping_provider.dao.WphSpuattributeDao;
import com.example.wph_shoping_provider.entity.WphShopingpicture;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.MapSolrParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class SolrServiceImpl implements com.example.wph_shoping_provider.service.SolrService
{
    @Autowired
    private SolrClient client;
    @Autowired
    private WphShopingpictureDao wphShopingpictureDao;
    @Override
    public String shopSearch(String words) throws IOException, SolrServerException {
        String str = null;
        List<Object> solrShuju=new ArrayList<>();
        Map<String, String> queryParamMap = new HashMap<String, String>();
        queryParamMap.put("q","name:*"+words+"*");
       /* queryParamMap.put("start","1");
        queryParamMap.put("rows","3");*/
        MapSolrParams mapSolrParams = new MapSolrParams(queryParamMap);

        QueryResponse query = client.query("ws",mapSolrParams);
        SolrDocumentList results = query.getResults();
        System.out.println(results.size());
        for (int i=0;i<results.size();i++){
            List<String> solrShujus=new ArrayList<>();
            solrShujus.add((String) results.get(i).get("name"));
            solrShujus.add((String)results.get(i).get("details"));
            solrShujus.add((String)results.get(i).get("brandid"));
            solrShujus.add((String)results.get(i).get("id"));
            solrShujus.add((String)results.get(i).get("listmoney"));
            int imager = Integer.parseInt((String) results.get(i).get("imager"));
            WphShopingpicture wphShopingpicture = wphShopingpictureDao.queryById(imager);
            solrShujus.add(wphShopingpicture.getPictureAddress());
            solrShuju.add(solrShujus);
        }
        if (!solrShuju.isEmpty()){
            str = JSON.toJSONString(solrShuju);
        }
        return str;
    }
}
