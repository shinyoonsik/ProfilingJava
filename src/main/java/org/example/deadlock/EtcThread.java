package org.example.deadlock;

import java.util.logging.Logger;

public class EtcThread extends Thread{
    private final Logger log = Logger.getLogger(EtcThread.class.getName());

    public EtcThread(String name){
        super(name);
    }

    @Override
    public void run(){
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            log.info("I'm EtcThread!!!!");
        }
    }
}
