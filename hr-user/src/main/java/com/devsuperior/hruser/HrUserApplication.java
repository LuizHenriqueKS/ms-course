package com.devsuperior.hruser;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HrUserApplication implements CommandLineRunner {

    // @Autowired
    // private BCryptPasswordEncoder passwordEncoder;

    // @Value("${test.config}")
    // private String testConfig;

    public static void main(String[] args) {
        SpringApplication.run(HrUserApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // log.info("BCRYPT = {}", passwordEncoder.encode("123456"));
        // log.info("TEST_CONFIG = {}", testConfig);
    }

}
