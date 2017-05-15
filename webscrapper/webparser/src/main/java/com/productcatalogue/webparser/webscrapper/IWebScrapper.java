package com.productcatalogue.webparser.webscrapper;

import java.util.Optional;

/**
 * Created by vinodm1986 on 5/13/17.
 */
public interface IWebScrapper {
    Optional<String> fetchPrice(String seller, String URL);
}
