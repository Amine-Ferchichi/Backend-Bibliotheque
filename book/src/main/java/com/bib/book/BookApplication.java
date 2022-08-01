package com.bib.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import java.util.Arrays;
@SpringBootApplication
@EnableEurekaClient
public class BookApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class,args);
    }


}
