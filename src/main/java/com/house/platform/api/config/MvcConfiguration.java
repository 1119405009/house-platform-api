package com.house.platform.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by teruo on 2018/2/5.
 */
@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("Content-Type", "Access-Control-Allow-Headers", "Authorization",
                        "X-Requested-With", "X-Request-Token", "Content-Disposition", "Cache-Control",
                        "If-Modified-Since", "User-Agent", "Keep-Alive", "X-CustomHeader", "DNT")
                .allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS", "PATCH")
                .allowCredentials(true).maxAge(3600);
    }
}
