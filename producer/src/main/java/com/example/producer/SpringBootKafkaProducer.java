package com.example.producer;

import com.example.producer.model.Aggregate.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootKafkaProducer {

	private static final Logger log = LoggerFactory.getLogger(SpringBootKafkaProducer.class);
	private static final String url = "https://random-data-api.com/api/product/random_product";

	public static void main(String[] args) {
		SpringApplication.run(SpringBootKafkaProducer.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate, StreamBridge streamBridge) throws Exception {
		return args -> {
			try {
				while (!Thread.currentThread().isInterrupted()){
					Product product = restTemplate.getForObject(url, Product.class);
					assert product != null;
					log.info(product.toString());
					//The binder name "appliance-outbound" is defined in the application.yml.
					streamBridge.send("product-outbound", product);
					Thread.sleep(1200);
				}
			}
			catch(InterruptedException ignored){}
		};
	}
}
