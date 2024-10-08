package org.example.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "httpBin", url = "https://httpbin.org/")
public interface DemoProxy {

    @PostMapping("/delay/{n}")
    void delay(@PathVariable int n);
}
