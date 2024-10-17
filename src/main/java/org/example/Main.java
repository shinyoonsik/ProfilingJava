package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.ArrayList;
import java.util.List;

@EnableFeignClients
@SpringBootApplication
public class Main {

    public static final List<Integer> commonList = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Main.class, args);
    }
}