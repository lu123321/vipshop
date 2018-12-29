package com.example.wph_shoping_provider.controller;

import com.example.wph_shoping_provider.service.SolrService;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
@Controller
@RequestMapping("/solr")
public class WphSolrController {
    @Autowired
    private SolrService solrService;

    @RequestMapping(value = "/shopSerrchs",method = RequestMethod.POST,produces = "text/html;charset=utf-8")
    @ResponseBody
    public String shopSearch(@RequestParam("words") String words) throws IOException, SolrServerException{
        System.out.println(words);
        System.out.println(solrService.shopSearch(words));
       return solrService.shopSearch(words);
   }
}
