package com.example.clientbackrequest;

import com.example.clientbackrequest.model.Supplier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoApplication {

    final String rootUrl = "http://localhost:8080/libraries";

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {

        return args -> {

            // CREATE
            Supplier entry = new Supplier();
            entry.setCompanyName("my Supplier ");
            Supplier supplier = restTemplate.postForObject(rootUrl, entry, Supplier.class);
            assert supplier != null;
            System.out.println("****CREATE****" + supplier);
            // READ
            restTemplate.getForObject(rootUrl+"/"+supplier.getId(), Supplier.class);
            System.out.println("****READ**** "+ supplier);
            // UPDATE
            supplier.setCompanyName("my new library");
            HttpEntity<Supplier> update = new HttpEntity<>(supplier);
            restTemplate.exchange(rootUrl+"/"+supplier.getId(), HttpMethod.PUT, update, Void.class);
            System.out.println("****UPDATE****"+ supplier);
            //DELETE
            //TODO
        };

    }

}
