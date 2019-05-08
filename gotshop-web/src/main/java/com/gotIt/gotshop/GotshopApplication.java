package com.gotIt.gotshop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableConfigurationProperties
@EnableSwagger2
@EnableCaching
@SpringBootApplication
@Slf4j
public class GotshopApplication {

	public static void main(String[] args) {
		SpringApplication application =new SpringApplication(GotshopApplication.class);
		//application.setAdditionalProfiles("prod");
		application.run(args);
	}

}
