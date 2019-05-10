package com.gotIt.gotshop.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
@Slf4j
public class SwaggerController {

    @GetMapping("/hello")
    public String hello(){
        log.info("hello swagger");
        return "hello swagger";
    }
}
