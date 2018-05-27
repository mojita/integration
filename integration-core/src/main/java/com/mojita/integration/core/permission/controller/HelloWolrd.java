package com.mojita.integration.core.permission.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijunhong
 * @since 18/5/27 上午3:15
 */
@RestController
public class HelloWolrd {

    @RequestMapping("/hello")
    public String hellow() {
        return "hello world";
    }
}
