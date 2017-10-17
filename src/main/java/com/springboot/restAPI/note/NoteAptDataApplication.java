package com.springboot.restAPI.note;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableJSONDoc
public class NoteAptDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoteAptDataApplication.class, args);
	}
}