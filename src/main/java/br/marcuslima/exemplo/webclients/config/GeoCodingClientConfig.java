package br.marcuslima.exemplo.webclients.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;

@Configuration
public class GeoCodingClientConfig {

    @Bean
    public RequestInterceptor userAgentInterceptor() {
        return template -> template.header("User-Agent", "Example/1.0");
    }

}
