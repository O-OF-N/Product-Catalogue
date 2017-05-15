package com.productcatalogue;

import com.productcatalogue.webscrapper.controller.QueueListenerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebscrapperApplication {

    @Autowired
    private QueueListenerController queueListenerController;

    public static void main(String[] args) {
        SpringApplication.run(WebscrapperApplication.class, args);
    }
}


