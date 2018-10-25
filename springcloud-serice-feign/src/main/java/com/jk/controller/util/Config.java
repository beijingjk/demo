package com.jk.controller.util;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {


    @Bean
    public Queue queueMessage1(){
        return  new Queue("topic_1");
    }

    @Bean
    public Queue queueMessage2(){
        return  new Queue("topic_2");
    }

    @Bean
    TopicExchange exchange(){
        return new TopicExchange("exchage_topic");
    }
    //Direct交换机的绑定

    @Bean
    Binding bindingExchangeMessage(Queue queueMessage1, TopicExchange exchange){
        return BindingBuilder.bind(queueMessage1).to(exchange).with("topic.info");
    }


    //Topic交换机的绑定
    @Bean
    Binding bindingExchangeMessages(Queue queueMessage2, TopicExchange exchange){
        return BindingBuilder.bind(queueMessage2).to(exchange).with("topic.email");
    }




}
