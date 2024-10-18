package org.example.controller;

import org.example.model.MyProduct;
import org.example.service.JmxService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

@RestController
@RequestMapping("jmx")
public class JmxController {

    private final Logger log = Logger.getLogger(JmxController.class.getName());

    private final JmxService jmxService;

    public JmxController(JmxService jmxService) {
        this.jmxService = jmxService;
    }

    @GetMapping("/heapDump")
    public void dumpHeap(@RequestParam(name = "file") String outputFile){
        if(!StringUtils.hasText(outputFile)) throw new IllegalArgumentException("there is no outputFile");

        this.jmxService.dumpHeap(outputFile);
    }

    @GetMapping("/occur-oom")
    public void occurrOOM(){
        List<MyProduct> myProductList = new ArrayList<>();
        double number = 0;
        log.info("[JmxController] Current_thread: " + Thread.currentThread().getName());
        while(true){
            Random random = new Random();
            int randomPrice = random.nextInt();
            MyProduct product = new MyProduct("product_" + number, randomPrice);
            myProductList.add(product);
            number++;
        }
    }
}
