package org.example;

import org.example.deadlock.Consumer;
import org.example.deadlock.Producer;

import java.util.ArrayList;
import java.util.List;

//@EnableFeignClients
//@SpringBootApplication
public class Main {

    public static final List<Integer> commonList = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
//        SpringApplication.run(Main.class, args);
        new Consumer("_Consumer").start();
        new Producer("_Producer").start();
    }
}