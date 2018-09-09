package com.basedatos1.BaseDatos1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = "com.basedatos1.entidades")
@ComponentScan(basePackages = {"com.basedatos1.controladores"})
public class BaseDatos1Application {

	public static void main(String[] args) {
		SpringApplication.run(BaseDatos1Application.class, args);
	}
}
