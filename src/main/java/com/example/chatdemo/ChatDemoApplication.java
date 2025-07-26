package com.example.chatdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatDemoApplication {

	public static void main(String[] args) {
		System.out.println("=== ChatDemoApplication 启动 ===");

		SpringApplication.run(ChatDemoApplication.class, args);
	}

}
