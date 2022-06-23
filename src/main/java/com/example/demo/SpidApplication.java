package com.example.demo;

import com.example.demo.model.Spid;
import com.example.demo.model.User;
import com.example.demo.utils.Status;
import com.example.demo.utils.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpidApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpidApplication.class, args);
	}

}
