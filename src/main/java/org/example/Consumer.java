package org.example;

import java.util.logging.Logger;

public class Consumer extends Thread {
    private Logger log = Logger.getLogger(Consumer.class.getName());

    public Consumer(String name){
        super(name);
    }

    @Override
    public void run() {
        while(true){
            synchronized (Main.list){
                if(Main.list.size() > 0){
                    Integer removedElement = Main.list.get(0);
                    Main.list.remove(0);

                    log.info("Consumer " + Thread.currentThread().getName() + " 제거된 value: " + removedElement);
                }
            }
        }
    }
}
