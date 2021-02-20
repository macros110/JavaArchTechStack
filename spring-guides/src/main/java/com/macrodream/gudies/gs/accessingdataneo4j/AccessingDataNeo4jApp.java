package com.macrodream.gudies.gs.accessingdataneo4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableNeo4jRepositories
public class AccessingDataNeo4jApp {

    private final static Logger log = LoggerFactory.getLogger(AccessingDataNeo4jApp.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataNeo4jApp.class,args);
        System.exit(0);
    }

    @Bean
    CommandLineRunner demo(PersonRepository repository){
        return args -> {
            repository.deleteAll();
            Person greg = new Person("Greg");
            Person roy = new Person("Roy");
            Person craig = new Person("Craig");
            List<Person> team = Arrays.asList(greg, roy , craig);

            log.info("Before linking up with Neo4j...");

            team.stream().forEach(person -> log.info("\t"+person.toString()));

            repository.save(greg);
            repository.save(roy);
            repository.save(craig);

            greg = repository.findByName(greg.getName());
            greg.worksWith(roy);
            greg.worksWith(craig);
            repository.save(greg);

            roy = repository.findByName(roy.getName());
            roy.worksWith(craig);
            //We already know that roy works with greg
            repository.save(roy);

            //We already know craig works with roy and greg
            log.info("Lookup each person by name...");
            team.stream().forEach(person -> log.info("\t"+repository.findByName(person.getName()).toString()));

            List<Person> teammates = repository.findByTeammatesName(greg.getName());
            log.info("The following have Greg as a teammate...");
            teammates.stream().forEach(person -> log.info("\t"+person.getName()));
        };
    }
}
