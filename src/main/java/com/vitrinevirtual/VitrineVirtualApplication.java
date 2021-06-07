package com.vitrinevirtual;

import java.sql.Time;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class VitrineVirtualApplication {

	public static void main(String[] args) {
		SpringApplication.run(VitrineVirtualApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("123"));
	}

}
