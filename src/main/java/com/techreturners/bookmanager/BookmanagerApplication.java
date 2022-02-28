package com.techreturners.bookmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class BookmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmanagerApplication.class, args);



	}
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.OAS_30)
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.withClassAnnotation
						(RestController.class))
				.build()
				.apiInfo(apiInformation());
	}
	private ApiInfo apiInformation() {
		return new ApiInfoBuilder()
				.title("\uD83D\uDCDA Book Manager API")
				.description("This API helps you manage your books \uD83D\uDCDD")
				.version("v1")
				.build();
	}

}
