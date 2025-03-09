package com.hamiltongomes.todolist.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("API todolist")
                        .version("1.0")
                        .description("Documentação da API do desafio backend da Simplify")
                        .contact(new Contact()
                                .name("Hamilton Gomes")
                                .email("hamilton.gomes8@hotmail.com")
                                .url("https://github.com/hamiltonGomes/todolist-challenge-backend-simplify")));
    }
}