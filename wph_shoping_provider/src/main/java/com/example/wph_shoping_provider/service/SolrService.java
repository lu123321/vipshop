package com.example.wph_shoping_provider.service;

import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;

public interface SolrService {
    String shopSearch(String words) throws IOException, SolrServerException;
}
