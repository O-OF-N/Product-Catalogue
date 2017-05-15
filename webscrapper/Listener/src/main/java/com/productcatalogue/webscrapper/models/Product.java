package com.productcatalogue.webscrapper.models;

import java.util.Map;

/**
 * Created by vinodm1986 on 5/11/17.
 */
public class Product {
    private String seller;
    private String url;
    private Map<Long, Number> timeCost;
    private Long firstScan;

    public Product(String url, Long firstScan, Map<Long, Number> timeCost) {
        this.url = url;
        this.timeCost = timeCost;
        this.firstScan = firstScan;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Long getFirstScan() {
        return firstScan;
    }

    public void setFirstScan(Long firstScan) {
        this.firstScan = firstScan;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<Long, Number> getTimeCost() {
        return timeCost;
    }

    public void setTimeCost(Map<Long, Number> timeCost) {
        this.timeCost = timeCost;
    }
}
