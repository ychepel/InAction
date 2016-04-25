package com.univer.inaction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping(value = "/home")
    @ResponseBody
    public String doSomething() {
        return "hello world!";
    }
}
