package com.devsuperior.hrworker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import lombok.extern.log4j.Log4j2;

@Log4j2
@EnableEurekaClient
@SpringBootApplication
public class HrWorkerApplication implements CommandLineRunner {

    @Value("${test.config}")
    private String testConfig;

    public static void main(String[] args) {
        SpringApplication.run(HrWorkerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("test.config: " + testConfig);
    }

}
