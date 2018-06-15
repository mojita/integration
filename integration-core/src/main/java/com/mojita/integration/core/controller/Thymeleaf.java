package com.mojita.integration.core.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lijunhong
 * @since 18/6/13 上午12:00
 */
@RestController
@RequestMapping("/thymeleaf")
public class Thymeleaf {


    @RequestMapping("/greeting")
    public ModelAndView test(ModelAndView mv) {
        mv.setViewName("login");
        mv.addObject("title","欢迎登录");
        return mv;

    }



}
