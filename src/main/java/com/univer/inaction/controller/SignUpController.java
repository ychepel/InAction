package com.univer.inaction.controller;

import com.univer.inaction.entity.User;
import com.univer.inaction.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@Slf4j
public class SignUpController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signup", method= RequestMethod.GET)
    public ModelAndView getSignUp() {
        log.debug("Get ModelAndView in getSignUp()");

        ModelAndView modelAndView = new ModelAndView("signup/signup");
        modelAndView.addObject("signupForm", new User());
        log.debug("Current ModelAndView - " + modelAndView);

        return modelAndView;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String postSignUp(@Valid @ModelAttribute("signupForm") User user, BindingResult result, Model model) {
        log.debug("Receive SignUp form - " + user);
        log.debug("POST model - " + model);

        if(result.hasErrors()) {
            log.warn(result.toString());
            return "signup/signup";
        }

        User savedUser = userService.save(user);
        return "redirect:/";
    }
}
