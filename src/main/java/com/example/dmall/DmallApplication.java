package com.example.dmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.dmall.mapper")
public class DmallApplication {

	public static void main(String[] args) {
		SpringApplication.run(DmallApplication.class, args);
	}

}
