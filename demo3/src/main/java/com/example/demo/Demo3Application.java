package com.example.demo;

import java.io.File;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo3Application {

	public static void main(String[] args) throws IOException {
		File file = new File("data.json");
		try {
			if (file.delete())
				file.createNewFile();
			else
				file.createNewFile();
			System.out.println("data.json created");
		}
		catch (Exception e) {
			System.out.println("data.json not created");
		}
		
		SpringApplication.run(Demo3Application.class, args);
	}
}
