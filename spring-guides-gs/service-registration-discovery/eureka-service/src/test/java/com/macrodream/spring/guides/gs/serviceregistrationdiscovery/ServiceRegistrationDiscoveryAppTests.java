package com.macrodream.spring.guides.gs.serviceregistrationdiscovery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServiceRegistrationDiscoveryAppTests {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void shouldStartEurekaServer(){
        ResponseEntity<String> entity = this.testRestTemplate
                .getForEntity("http://localhost:"+this.port+"/eureka/apps", String.class);
        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
