package org.example.deadlock;

import java.util.Random;
import java.util.logging.Logger;

public class Producer extends Thread {

    private final Logger log = Logger.getLogger(Producer.class.getName());

    public Producer(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            synchronized (SharedResources.listB) {

                for (int i = 0; i < 1_000_000_000; i++) {}
                log.info("Producer ing~~~~~~");
                synchronized (SharedResources.listA) {
                    if(SharedResources.listB.size() < 100){
                        Random random = new Random();
                        int element = random.nextInt();
                        SharedResources.listB.add(element);
                        log.info("[Producer] [listB] 추가된 원소: " + element);
                    }else if(SharedResources.listA.size() < 100){
                        Random random = new Random();
                        int element = random.nextInt();
                        SharedResources.listA.add(element);
                        log.info("[Producer] [listA] 추가된 원소: " + element);
                    }
                }
            }
        }
    }
}
