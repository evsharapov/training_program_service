package com.example.trainingprogramservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class TrainingProgramServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrainingProgramServiceApplication.class, args);
    }

}
