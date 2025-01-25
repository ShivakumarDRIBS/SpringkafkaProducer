package com.shiva.kafka_producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
This file is used for creating kafka topics from java code.
When application starts, shiva-config-topic will be created automatically.
 */
@Configuration
public class kafkaTopicCreation {
    @Bean
    public NewTopic createTopic(){
        return new NewTopic("shiva-config-topic",5,(short)1);
    }
}
