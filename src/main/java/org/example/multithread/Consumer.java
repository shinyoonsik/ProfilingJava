package org.example.multithread;

import java.util.logging.Logger;

import static org.example.Main.commonList;

public class Consumer extends Thread {

    private final Logger log = Logger.getLogger(Consumer.class.getName());

    public Consumer(String name) {
        super(name);
    }

    @Override
    public void run() {
        while(true){
            synchronized (commonList){
                if(commonList.size() > 0){
                    Integer firstElement = commonList.get(0);
                    commonList.remove(0);

                    log.info("[Consumer] 제거된 원소: " + firstElement + " 현재 스레드: " + Thread.currentThread().getName());
                    commonList.notifyAll();
                }else{
                    try {
                        commonList.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
