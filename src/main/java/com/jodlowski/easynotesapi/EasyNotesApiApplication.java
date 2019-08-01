package com.jodlowski.easynotesapi;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EasyNotesApiApplication {

	public static Logger logger = Logger.getLogger(EasyNotesApiApplication.class);

	public static void main(String[] args) {
		logger.info("Easy Notes application starting");
		SpringApplication.run(EasyNotesApiApplication.class, args);
	}

}
