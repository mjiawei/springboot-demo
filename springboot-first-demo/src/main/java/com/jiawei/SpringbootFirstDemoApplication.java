package com.jiawei;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.jiawei.mapper")
@EnableSwagger2
public class SpringbootFirstDemoApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringbootFirstDemoApplication.class);

	public static void main(String[] args) {
		logger.info("start!!!!!!!");
		SpringApplication.run(SpringbootFirstDemoApplication.class, args);
	}
}
