package org.example.deadlock;

import java.util.logging.Logger;

public class Consumer extends Thread{

    private final Logger log = Logger.getLogger(Consumer.class.getName());

    public Consumer(String name){
        super(name);
    }

    @Override
    public void run(){
        while(true){
            synchronized (SharedResources.listA){

                // do something
                for(int i=0; i<1_000_000_000; i++){}
                log.info("Consumer ing~~~~~~");
                synchronized (SharedResources.listB){
                    if(SharedResources.listA.size() > 0){
                        int element = SharedResources.listA.get(0);
                        SharedResources.listA.remove(0);
                        log.info("[Consumer] [listA] 제거된 원소: " + element);
                    }else if (SharedResources.listB.size() > 0){
                        int element = SharedResources.listB.get(0);
                        SharedResources.listB.remove(0);
                        log.info("[Consumer] [listB] 제거된 원소: " + element);
                    }
                }
            }
        }
    }
}
