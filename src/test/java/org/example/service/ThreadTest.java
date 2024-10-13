package org.example.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ThreadTest {

    @Test
    @DisplayName("개별적으로 동작하는 스레드 테스트")
    void test() throws InterruptedException {
        Thread subThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("subThreadName: " + Thread.currentThread().getName());
        });

        subThread.start();

        System.out.println("main Test Thread: " + Thread.currentThread().getName());

        subThread.join();
    }

    @Test
    @DisplayName("데몬스레드 라이프사이클 테스트")
    void test_daemon(){
        Thread userThread = new Thread(() -> {

            System.out.println("User thread 시작");

            Thread daemonThread = new Thread(() -> {
                while (true) {
                    System.out.println("I'm daemon thread!!!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

            daemonThread.setDaemon(true);
            daemonThread.start();

            try {
                // userThread 2초 대기후 종료
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("User thread 종료");
        });

        userThread.start();

        int count = 0;
        while(true){
            count++;
            if(count == 1000) break;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
