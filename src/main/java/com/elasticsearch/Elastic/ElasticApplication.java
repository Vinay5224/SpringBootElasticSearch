package com.elasticsearch.Elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElasticApplication {

	public static String user;
	public static void main(String[] args) {
		SpringApplication.run(ElasticApplication.class, args);
	}

}
