package com.mojita.integration.core.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mojita.integration.core.entity.Student;

/**
 * @author lijunhong
 * @since 18/6/14 上午10:48
 */
@RequestMapping("/student")
@RestController
public class SutdentController {

    @RequestMapping("/add")
    public void addStudent(@RequestBody @Validated Student student) {
        System.out.println(student.toString());
//        throw new RuntimeException("测试异常");
    }
}
