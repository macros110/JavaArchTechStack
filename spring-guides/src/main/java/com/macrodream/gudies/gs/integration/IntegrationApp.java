package com.macrodream.gudies.gs.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import java.io.IOException;

/**
 * Integrating Data
 */
@SpringBootApplication
@ImportResource("/integration/integration.xml")
public class IntegrationApp {
    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext ctx = new SpringApplication(IntegrationApp.class).run(args);
        System.out.println("Hit Enter to terminate");
        System.in.read();
        ctx.close();
    }
}
