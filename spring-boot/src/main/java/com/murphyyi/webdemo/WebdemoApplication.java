package com.murphyyi.webdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class WebdemoApplication {

    @RequestMapping("/")
    String index() {
        return "Hello Spring boot";
    }
    public static void main(String[] args) {
        SpringApplication.run(WebdemoApplication.class, args);
    }
}
