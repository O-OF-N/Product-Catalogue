package com.productcatalogue.webparser.dao;

import com.productcatalogue.webparser.models.Selector;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 * Created by vinodm1986 on 5/12/17.
 */
public interface ISelectorDao extends MongoRepository<Selector,String> {
}
