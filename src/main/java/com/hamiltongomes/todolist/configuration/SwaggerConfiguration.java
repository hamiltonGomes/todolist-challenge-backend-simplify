package com.hamiltongomes.todolist.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Todolist API")
                        .version("1.0.0")
                        .description("API de gerenciamento de tarefas, desenvolvida como parte do desafio backend Simplify. Permite criar, atualizar, listar e excluir tarefas.")
                        .contact(new Contact()
                                .name("Hamilton Gomes")
                                .email("hamilton.gomes8@hotmail.com")
                                .url("https://github.com/hamiltonGomes/todolist-challenge-backend-simplify"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT")));
    }
}
