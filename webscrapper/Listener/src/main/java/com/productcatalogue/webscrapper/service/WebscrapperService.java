package com.productcatalogue.webscrapper.service;

import com.productcatalogue.webscrapper.dao.IWebscrapperDao;
import com.productcatalogue.webscrapper.models.PersonProduct;
import com.productcatalogue.webscrapper.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.productcatalogue.webparser.webscrapper.IWebScrapper;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Created by vinodm1986 on 4/16/17.
 */
@Service("webscrapperService")
public class WebscrapperService implements IWebscrapperService {

    @Autowired
    private IWebscrapperDao webscrapperDao;

    @Autowired
    private IWebScrapper webScrapper;

    private Supplier<Long> cutOffDate = () -> {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -2);
        return cal.getTime().getTime();
    };

    private Function<Optional<String>, Optional<Number>> longPrice = price -> {
        try {
            NumberFormat format = NumberFormat.getCurrencyInstance();
            Number number = format.parse(price.get());
            return Optional.of(number);
        } catch (ParseException ex) {
            return Optional.empty();
        }
    };

    private Function<Product, Product> updatePrice = product -> {
        try {
            if (product == null) return product;
            final Long currentTime = new Date().getTime();
            Optional<String> cost = webScrapper.fetchPrice(product.getSeller(), product.getUrl());
            System.out.println("cost = " + cost);
            if (cost.isPresent())
                product.getTimeCost().put(currentTime, longPrice.apply(cost).get());
            return product;
        } catch (Exception e) {
            e.printStackTrace();
            return product;
        }
    };

    private Function<Set<Product>, Optional<Set<Product>>> processProducts = products ->
            Optional.of(products.parallelStream().map(updatePrice)
                    .collect(Collectors.toSet()));

    public boolean processPerson(String id) {
        final PersonProduct personProduct = webscrapperDao.findOne(id);
        if (personProduct == null) return false;
        final Long lastScanDate = personProduct.getLastScanDate();
        if (lastScanDate > cutOffDate.get()) {
            Optional<Set<Product>> products = processProducts.apply(personProduct.getProducts());
            if (products.isPresent() && products.get().size() == personProduct.getProducts().size()) {
                personProduct.setProducts(products.get());
                webscrapperDao.save(personProduct);
                return true;
            }
        }
        return false;
    }
}

