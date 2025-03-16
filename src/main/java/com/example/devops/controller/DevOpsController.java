package com.example.devops.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping
public class DevOpsController {

    @GetMapping("/info")
    public String getInfo(){
        return "INFO::: " + LocalDateTime.now();
    }

    @GetMapping("/warn")
    public String getWarn(){
        return "WARN::: " + LocalDateTime.now();
    }
}
