package com.zbx.system.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/say")
    public String say() {
        return "Hello,world!";
    }
}
