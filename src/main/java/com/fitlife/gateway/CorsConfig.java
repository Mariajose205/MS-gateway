package com.fitlife.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.reactive.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {

    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        
        // Permitimos explícitamente el origen de tu frontend y localhost para pruebas
        corsConfig.addAllowedOrigin("http://34.205.253.0");
        corsConfig.addAllowedOrigin("http://34.205.253.0:80"); // Frontend en puerto 80
        corsConfig.addAllowedOrigin("http://localhost:3000"); // Por si pruebas local
        corsConfig.addAllowedOriginPattern("*"); // Respaldo para desarrollo
        
        corsConfig.addAllowedMethod("*"); // Permite GET, POST, PUT, DELETE, OPTIONS
        corsConfig.addAllowedHeader("*"); // Permite todas las cabeceras (Authorization, Content-Type, etc.)
        corsConfig.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsWebFilter(source);
    }
}