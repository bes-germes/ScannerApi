package com.example.scannerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ScannerApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScannerApiApplication.class, args);
    }

    @GetMapping
    public String hello(){
        return "Server is working";
    }
}
