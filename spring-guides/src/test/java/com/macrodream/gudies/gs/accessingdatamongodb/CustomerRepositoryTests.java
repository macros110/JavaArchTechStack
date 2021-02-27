package com.macrodream.gudies.gs.accessingdatamongodb;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CustomerRepositoryTests {
    @Autowired
    CustomerRespository respository;

    Customer dave, oliver, carter;

    @BeforeEach
    public void setUp(){
        respository.deleteAll();
        dave = respository.save(new Customer("Dave","Matthews"));
        oliver = respository.save(new Customer("Oliver August","Matthews"));
        carter = respository.save(new Customer("Carter","Beauford"));
    }
    @Test
    public void setsIdOnSave(){
        Customer dave = respository.save(new Customer("Dave","Matthews"));
        assertThat(dave.id).isNotNull();
    }
    @Test
    public void findsByLastName(){
        List<Customer> result = respository.findByLastName("Beauford");
        assertThat(result).hasSize(1).extracting("firstName").contains("Carter");
    }
    @Test
    public void findsByExample(){
        Customer probe = new Customer(null, "Matthews");
        List<Customer> result = respository.findAll(Example.of(probe));
        assertThat(result).hasSize(2).extracting("firstName").contains("Dave","Oliver August");
    }
}
