package com.syrongk.ddd.study.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/home")
    public String hello() {
        return "Hello, it's me";
    }
}
