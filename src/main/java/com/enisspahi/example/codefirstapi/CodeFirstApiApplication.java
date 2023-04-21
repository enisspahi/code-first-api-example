package com.enisspahi.example.codefirstapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Code First Open API spec example", version = "1.0"))
public class CodeFirstApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeFirstApiApplication.class, args);
	}

}
