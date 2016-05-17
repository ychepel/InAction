package com.univer.inaction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignInController {

    @RequestMapping(value = "/signin")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("signin/signin");
        return modelAndView;
    }
}
