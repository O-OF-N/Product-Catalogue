package com.productcatalogue.webscrapper.controller;

import com.productcatalogue.webscrapper.service.IWebscrapperService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;


/**
 * Created by vinodm1986 on 4/17/17.
 */
@Controller
public class QueueListenerController implements MessageListener{
    @Autowired
    @Qualifier("webscrapperService")
    private IWebscrapperService webscrapperService;


    @Override
    public void onMessage(Message message) {
        String id = new String(message.getBody());
        System.out.println("id = " + id);
        if(webscrapperService.processPerson(id)){
            System.out.println("Success");
        } else System.out.println("Failed");
    }
}
