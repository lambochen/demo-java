package cn.lambochen.demo.spock.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/7/10
 * @description Controller 测试
 **/
@RestController
@RequestMapping("/hello")
public class WebController {

    @GetMapping
    public String hello() {
        return "Hello";
    }

}
