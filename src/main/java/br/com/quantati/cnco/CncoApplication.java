package br.com.quantati.cnco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableCaching
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class CncoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CncoApplication.class, args);
	}
}
