package com.productcatalogue.webparser.service;

import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Created by vinodm1986 on 5/13/17.
 */
@Component("Amazon")
public final class Amazon implements ISeller {

    public Optional<String> getPrice(final List<String> selectors,final  int index,final  Element element) {
        String selector = selectors.get(index);
        Element nextElement = element.select(selector).first();
        if (index < selectors.size() - 1) {
            getPrice(selectors, index + 1, nextElement);
        } else {
            return Optional.of(nextElement.text());
        }
        return Optional.empty();
    }
}
