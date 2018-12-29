package com.example.wph_shoping_provider.controller;

import com.example.wph_shoping_provider.service.*;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TestController {
   /* @Autowired
    SolrService solrService;

    @RequestMapping("/text")
    public String Test(){
        try {
            return solrService.shopSearch("华为");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
        return null;
    }*/
}
