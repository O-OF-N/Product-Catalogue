package com.productcatalogue.webparser.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

/**
 * Created by vinodm1986 on 5/12/17.
 */
@Document(collection = "selectors")
public class Selector {
    @Id
    private String id;
    private Map<String, List<String>> selectors;

    public Map<String, List<String>> getSelectors() {
        return selectors;
    }

    public void setSelectors(Map<String, List<String>> selectors) {
        this.selectors = selectors;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
