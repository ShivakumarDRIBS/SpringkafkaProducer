package com.shiva.kafka_producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessageToKafkaTopic(String message){
        CompletableFuture<SendResult<String, Object>> send = kafkaTemplate.send("shiva-topic", message);
        send.whenComplete((result,exc)->{
            if(exc==null){
                System.out.println("sent message=["+message+"]with offset=["+result.getRecordMetadata().offset()+"]");
            }else{
                System.out.println("Unbale to send messag=["+message+"] due to :" + exc.getMessage());
            }
        });
    }
}
