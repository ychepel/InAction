package com.univer.inaction.signup;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignUpController {

    @RequestMapping(value = "/signup")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("signup/signup");
        return modelAndView;
    }
}
