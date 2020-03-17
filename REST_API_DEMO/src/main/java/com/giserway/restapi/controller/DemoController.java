package com.giserway.restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {

    @GetMapping("/v1.0/demo")
    public String restDemo(){
        return "Hello, Restful API!";
    }
}

/**
    @RestController 相当于@ResponseBody 和 @Controller 两个注解，
                    所有返回的数据都会解析为 JSON 字符串响应前端，多用于API接口开发。

    @RequestMapping 表示请求映射 url

    @GetMapping 表示请求映射 url ，请求方式为 GET


 * */