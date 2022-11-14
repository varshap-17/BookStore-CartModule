package com.example.cartmodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class CartModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(CartModuleApplication.class, args);
    }
    @Bean
 //   @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
