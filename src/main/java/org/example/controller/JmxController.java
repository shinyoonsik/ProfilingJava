package org.example.controller;

import org.example.service.JmxService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("jmx")
public class JmxController {

    private final JmxService jmxService;

    public JmxController(JmxService jmxService) {
        this.jmxService = jmxService;
    }

    @GetMapping("/heapDump")
    public void dumpHeap(@RequestParam(name = "file") String outputFile){
        if(!StringUtils.hasText(outputFile)) throw new IllegalArgumentException("there is no outputFile");

        this.jmxService.dumpHeap(outputFile);
    }
}
