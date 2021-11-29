package br.com.bruno.core.base;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

public class WebConfig {

    @Configuration
    @EnableWebMvc
    public static class WebConfiguracao implements WebMvcConfigurer {
        public void addCorsMappings(CorsRegistry registry){
            registry.addMapping("/**")
                    .allowedMethods("GET", "POST", "PUT", "DELETE");
        }
    }
}
