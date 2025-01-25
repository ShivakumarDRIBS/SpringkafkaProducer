package com.shiva.kafka_producer.controller;

import com.shiva.kafka_producer.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/publish")
    public void getMessage(@RequestBody Employee employee){
        kafkaMessagePublisher.sendEventsToKafkaTopic(employee);
    }
}
