package com.macrodream.spring.gs.schedulingtasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling// ensures a background task executor
public class SchedulingTasksApp {
    public static void main(String[] args) {
        SpringApplication.run(SchedulingTasksApp.class);
    }
}
