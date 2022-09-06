package com.codestates.server.common.filter;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Collections;

@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Collections.singletonList("https://pre-project.vercel.app/"));
        configuration.addAllowedHeader("*");
        configuration.setAllowCredentials(true);            //  Whether to allow certificates （cookies）
        configuration.addAllowedMethod("*");            //  Set allowed methods
        configuration.addExposedHeader("access_token");
        configuration.addExposedHeader("refresh_token");
//        source.registerCorsConfiguration("/api/v1/**",configuration);
        source.registerCorsConfiguration("/**",configuration);
        return new CorsFilter(source);
    }

}
