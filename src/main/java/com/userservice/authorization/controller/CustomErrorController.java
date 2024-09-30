package com.userservice.authorization.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class CustomErrorController implements ErrorController {
    @RequestMapping(path = "/error")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String error() {
        return "forward:/";
    }
}
