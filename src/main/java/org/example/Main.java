package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static final List<Integer> list = new ArrayList<>();
    public static final List<Dog> dogList = new ArrayList<>();

    public static void main(String[] args) {
        new HardWorker("_HardWorker_1").start();
    }

    public static class HardWorker extends Thread {

        public HardWorker(String name){
            super(name);
        }

        @Override
        public void run(){
            while (true) {
                int age = new Random().nextInt(10);
                Dog dog = new Dog(age);
                dogList.add(dog);

//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
            }
        }
    }
}