package com.zb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/time")
    public String getStr(String str) {
        return str + new Date();
    }
}
