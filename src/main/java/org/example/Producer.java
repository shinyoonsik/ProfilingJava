package org.example;

import java.util.Random;
import java.util.logging.Logger;

public class Producer extends Thread{
    private Logger log = Logger.getLogger(Producer.class.getName());

    public Producer(String name){
        super(name);
    }

    @Override
    public void run(){
        Random random = new Random();
        while(true){
            synchronized (Main.list){
                int randomNumber = random.nextInt();
                Main.list.add(randomNumber);

                log.info("Producer " + Thread.currentThread().getName() + " 추가한 value: " + randomNumber);
                if(Main.list.size() < 100){
                }
            }
        }
    }
}
