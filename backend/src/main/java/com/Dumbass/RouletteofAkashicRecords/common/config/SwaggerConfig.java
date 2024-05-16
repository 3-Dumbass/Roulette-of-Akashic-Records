package com.Dumbass.RouletteofAkashicRecords.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    //접속주소:http://localhost:8080/swagger-ui/index.html
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Roulette of Akashic Records")
                        .description("뽑기 DB의 API")
                        .version("1.0.0"));
    }
}
