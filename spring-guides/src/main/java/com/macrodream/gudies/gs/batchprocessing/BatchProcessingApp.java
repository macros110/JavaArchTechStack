package com.macrodream.gudies.gs.batchprocessing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BatchProcessingApp {
    public static void main(String[] args) {
        System.exit(
                SpringApplication.exit(
                        SpringApplication.run(BatchProcessingApp.class,args)));
    }
}
