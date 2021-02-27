package com.macrodream.gudies.gs.accessingdatamongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessingDataMongodbApp implements CommandLineRunner {
    @Autowired
    private CustomerRespository respository;

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataMongodbApp.class,args);
    }
    @Override
    public void run(String... args) throws Exception {
        respository.deleteAll();

        //  save a couple of customers
        respository.save(new Customer("Alice","Smith"));
        respository.save(new Customer("Bob","Smith"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : respository.findAll()){
            System.out.println(customer);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Customer found with findByFirstName('Alice'):");
        System.out.println("---------------------------------------------");
        System.out.println(respository.findByFirstName("Alice"));

        System.out.println("Customer found with findByLastName('Smith'):");
        System.out.println("---------------------------------------------");
        for (Customer customer : respository.findByLastName("Smith")){
            System.out.println(customer);
        }

    }
}
