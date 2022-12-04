package com.syrongk.ddd.study.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/sample")
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello, it's me";
    }
}
