package com.macrodream.gudies.gs.uploadingfiles;

import com.macrodream.gudies.gs.uploadingfiles.storage.StorageProperties;
import com.macrodream.gudies.gs.uploadingfiles.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class UploadFilesApp {
    public static void main(String[] args) {
        SpringApplication.run(UploadFilesApp.class,args);
    }

    @Bean
    CommandLineRunner init(StorageService storageService){
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
}
