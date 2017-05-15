package com.productcatalogue.webscrapper.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Optional;
import java.util.Set;

/**
 * Created by vinodm1986 on 5/11/17.
 */
@Document(collection = "person-product ")
public class PersonProduct {
    @Id
    private String id;
    private String userName;
    private Long lastScanDate;
    private Set<Product> products;
    private Set<Product> archived;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getLastScanDate() {
        return lastScanDate;
    }

    public void setLastScanDate(Long lastScanDate) {
        this.lastScanDate = lastScanDate;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<Product> getArchived() {
        return archived;
    }

    public void setArchived(Set<Product> archived) {
        this.archived = archived;
    }
}
