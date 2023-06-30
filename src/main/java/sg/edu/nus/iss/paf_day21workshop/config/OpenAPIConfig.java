package sg.edu.nus.iss.paf_day21workshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {
    
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI().info(new Info()
            .title("My PAF Day 21 workshop PAF on swagger")
            .description("PAF Day 21 workshop")
            .version("Version 1.0"));
    }
}
