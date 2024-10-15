package com.example.accountdemo;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.rsocket.RSocketProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Value("${accountDemo.openapi.dev.url}")
    private String devUrl;

    @Value("${accountDemo.openapi.prod.url}")
    private String prodUrl;

    @Bean
    public OpenAPI myOpenAPI(){
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in the Development Environment");

        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Server Url in the Production Environment");

        Contact contact = new Contact();
        contact.setEmail("sue.mwemeke@gmail.com");
        contact.setName("smwemeke");
        contact.setUrl("https://www.linkedin.com/in/suzan-mwemeke-2b4ba670/ ");

        Info info = new Info()
                .title("Account Management API")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints");

        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));

    }
}
