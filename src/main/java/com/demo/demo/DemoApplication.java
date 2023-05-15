package com.demo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	/*
	 * @Bean public Docket api() { return new Docket(DocumentationType.SWAGGER_2)
	 * .select() .apis(RequestHandlerSelectors.basePackage("com.demo.demo"))
	 * .paths(PathSelectors.any()) .build() .apiInfo(apiInfo()); }
	 * 
	 * private ApiInfo apiInfo() { return new ApiInfoBuilder() .title("Example API")
	 * .description("Example API documentation") .version("1.0.0") .build(); }
	 */}
