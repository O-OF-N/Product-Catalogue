package com.productcatalogue.webparser.service;

import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Created by vinodm1986 on 5/14/17.
 */
@Component
@Qualifier("Walmart")
public final class Walmart implements ISeller {

    @Override
    public Optional<String> getPrice(final List<String> selectors, final int index, final Element element) {
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
