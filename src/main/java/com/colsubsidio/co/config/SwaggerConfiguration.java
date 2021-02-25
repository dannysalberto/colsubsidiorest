package com.colsubsidio.co.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

	@Bean
    public Docket testAngularWSApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(WSApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.colsubsidio.co.endpoints"))
                .build();
    }

    
   private ApiInfo WSApiInfo() {

        return new ApiInfoBuilder()
                .title("Web services Test, by Dannys Muria")
                .version("1.0")
                .build();

    }

}