package com.saranganrajan.apps.coredomainprocessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CoreDomainProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreDomainProcessorApplication.class, args);
	}

}
