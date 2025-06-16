package com.startkit.demo.config;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//This sets up Swagger. It's optional

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI baseOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Product API Demo")
                        .version("1.0.0")
                        .description("REST API documentation for products, categories, and suppliers"));
    }
}
