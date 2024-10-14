package org.example.producer;

import org.example.Main;

import java.util.Random;
import java.util.logging.Logger;

public class Producer extends Thread {

    private final Logger log = Logger.getLogger(Producer.currentThread().getName());

    public Producer(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            Random random = new Random();
            synchronized (Main.commonList) {
                if (Main.commonList.size() < 100) {
                    int x = random.nextInt();
                    Main.commonList.add(x);

                    log.info("[Producer] 생성된 원소: " + x + " 현재 스레드: " + Thread.currentThread().getName());
                    Main.commonList.notifyAll();
                } else {
                    try {
                        Main.commonList.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
