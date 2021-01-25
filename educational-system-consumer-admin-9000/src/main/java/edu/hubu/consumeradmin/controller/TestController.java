package edu.hubu.consumeradmin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author moonlan
 * date 2021/1/25 下午4:03
 */
@SuppressWarnings(value = "unused")
@RestController
public class TestController {

    @GetMapping("/test")
    public String hello() {
        throw new RuntimeException("HelloWorld");
    }

}
