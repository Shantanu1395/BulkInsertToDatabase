package com.industry_buying.industry_buying;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IndustryBuyingApplication {

	private static final Logger logger = LoggerFactory.getLogger(IndustryBuyingApplication.class);

	public static void main(String[] args) {
		logger.info("Staritng the application");
		SpringApplication.run(IndustryBuyingApplication.class, args);
	}

}
