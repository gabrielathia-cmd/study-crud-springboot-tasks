package com.gabrielathia.crudspringboottasks.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World de novo kkkk";
    }
}
