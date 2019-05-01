package com.gotIt.gotshop.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
@Slf4j
@Api(value = "测试 controller")
public class SwaggerController {

    @ApiOperation("测试 Swagger")
    @GetMapping("/hello")
    public String hello(){
        log.info("hello swagger");
        return "hello swagger";
    }
}
