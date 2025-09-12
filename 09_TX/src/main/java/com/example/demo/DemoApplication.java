package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
                                                                //run내의 reflection이 들어가있어서 demoapplication.class라는 문서를 전달하게 됨
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
