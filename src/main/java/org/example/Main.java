package org.example;

import org.example.consumer.Consumer;
import org.example.producer.Producer;

import java.util.ArrayList;
import java.util.List;

//@EnableFeignClients
//@SpringBootApplication
public class Main {

    public static final List<Integer> commonList = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
//        SpringApplication.run(Main.class, args);

        Thread.sleep(1000);

        new Producer("_Producer").start();
        new Consumer("_Consumer").start();
    }

}