package com.productcatalogue.webparser.webscrapper;

import com.productcatalogue.webparser.dao.ISelectorDao;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.productcatalogue.webparser.service.ISeller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by vinodm1986 on 5/13/17.
 */
@Component
public class WebScrapper implements IWebScrapper {

    @Autowired
    private ISelectorDao selectorDao;

    @Autowired
    @Qualifier("Amazon")
    private ISeller amazon;

    @Autowired
    @Qualifier("Walmart")
    private ISeller walmart;

    public Optional<String> fetchPrice(String seller, String URL){
        try {
            Map<String, List<String>> selectorMap = selectorDao.findAll().get(0).getSelectors();
            List<String> selectors = selectorMap.get(seller);
            if (null == selectors || selectors.size() < 1) return Optional.empty();
            Document document = Jsoup.connect(URL).timeout(5000).get();

            switch (seller) {
                case "Amazon":
                    return amazon.getPrice(selectors, 1,
                            document.select(selectors.get(0)).first());

                case "Walmart":
                    return walmart.getPrice(selectors, 1,
                            document.select(selectors.get(0)).first());
                default:
                    return Optional.empty();
            }

        } catch (Exception e){
            return Optional.empty();
        }
    }
}
