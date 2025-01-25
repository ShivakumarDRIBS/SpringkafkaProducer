package com.shiva.kafka_producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shiva.kafka_producer.service.KafkaMessagePublisher;

@RestController
@RequestMapping("/producer-app")
public class KafkaMessageController {

    @Autowired
    private KafkaMessagePublisher kafkaMessagePublisher;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable String message){
        for(int i=0;i<=10000;i++){
            kafkaMessagePublisher.sendMessageToKafkaTopic(message+" "+i);
        }
        return ResponseEntity.accepted().body("message publish..");
    }

    @GetMapping("/hello")
    public void getMessage(){
        System.out.println("Hello welcome");
    }
}
