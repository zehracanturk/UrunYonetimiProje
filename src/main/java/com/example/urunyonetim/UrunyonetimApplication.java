package com.example.urunyonetim;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAsync
public class UrunyonetimApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrunyonetimApplication.class, args);
	}

}
