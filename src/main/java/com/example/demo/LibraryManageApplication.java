package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class LibraryManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManageApplication.class, args);
	}

}
