package org.example.controller;

import org.example.proxy.DemoProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class DemoController {

    private final Logger log = Logger.getLogger(DemoController.class.getName());

    private final DemoProxy demoProxy;

    public DemoController(DemoProxy demoProxy) {
        this.demoProxy = demoProxy;
    }

    @GetMapping("/demo")
    public void demo() {
        log.info("DemoController의 demo()호출");
        log.info("현재 작업 스레드: " + Thread.currentThread().getName());
        this.demoProxy.delay(5);
    }

}
