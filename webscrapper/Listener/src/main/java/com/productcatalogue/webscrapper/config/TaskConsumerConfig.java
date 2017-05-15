package com.productcatalogue.webscrapper.config;

import com.productcatalogue.webscrapper.controller.QueueListenerController;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by vinodm1986 on 5/5/17.
 */
@Configuration
public class TaskConsumerConfig {
    protected final String queueName = "tasks.queue";

    public ConnectionFactory amqpConnectionFactory()
    {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setUri(
                "amqp://aobjrali:UdWuKUrWcd-3-j44H6rk6OhQwzHmw0Pn@salamander.rmq.cloudamqp.com/aobjrali");
        return connectionFactory;
    }

    public Queue tasksQueue()
    {
        return new Queue(this.queueName);
    }

    public MessageConverter jsonMessageConverter(){
        return new JsonMessageConverter();
    }

    @Bean
    public SimpleMessageListenerContainer listenerContainer(QueueListenerController queueListenerController) {
        SimpleMessageListenerContainer listenerContainer = new SimpleMessageListenerContainer();
        listenerContainer.setConnectionFactory(amqpConnectionFactory());
        listenerContainer.setQueues(tasksQueue());
        listenerContainer.setMessageConverter(jsonMessageConverter());
        listenerContainer.setMessageListener(queueListenerController);
        listenerContainer.setAcknowledgeMode(AcknowledgeMode.AUTO);
        return listenerContainer;
    }
}
