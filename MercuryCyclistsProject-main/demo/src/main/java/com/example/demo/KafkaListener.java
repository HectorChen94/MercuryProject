package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class KafkaListener {

    @KafkaListener (
            topic = "partb",
            partId = "partId"
            id     = "suppilerId"
    )
    void listener(String data){
        System.out.println("Listener received" +data);
    }

}
