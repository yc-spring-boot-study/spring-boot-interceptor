package com.chuan.handlerinterceptor.springbootinterceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class TestController {

    @GetMapping("hello")
    public String hello(){
        return "hello world";
    }



}
