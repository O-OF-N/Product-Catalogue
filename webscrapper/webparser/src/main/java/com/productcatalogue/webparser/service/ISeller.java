package com.productcatalogue.webparser.service;

import org.jsoup.nodes.Element;

import java.util.List;
import java.util.Optional;

/**
 * Created by vinodm1986 on 5/13/17.
 */
public interface ISeller {
    Optional<String> getPrice(List<String> selectors, int index, Element element);
}
