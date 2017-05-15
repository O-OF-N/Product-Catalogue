package com.productcatalogue.webscrapper.dao;

import com.productcatalogue.webscrapper.models.PersonProduct;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by vinodm1986 on 5/11/17.
 */
public interface IWebscrapperDao extends MongoRepository<PersonProduct,String> {
}
