package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/thread-info")
public class ThreadInfoController {

    private final Logger log = Logger.getLogger(ThreadInfoController.class.getName());
    private final ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

    @GetMapping("/threads")
    public List<String> getActiveThreads(){
        log.info("[ThreadInfoController] Current_thread: " + Thread.currentThread().getName());

        // 모든 스레드의 정보를 가져옴
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);

        return Arrays.stream(threadInfos)
                .map(threadInfo -> "Name: " + threadInfo.getThreadName() + ", State: " + threadInfo.getThreadState())
                .filter(threadInfo -> threadInfo.startsWith("Name: http-nio-"))
                .collect(Collectors.toList());
    }
}
