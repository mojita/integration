package com.mojita.integration.core.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lijunhong
 * @since 18/6/14 上午11:37
 */
@ControllerAdvice
public class ExceptionGlobal {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String exceptionHandler(Exception e) {
        return "Exception";
    }
}
