package com.univer.inaction.controller;

import com.univer.inaction.entity.User;
import com.univer.inaction.service.UserService;
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
public class SignUpController {

    private static Logger logger = LoggerFactory.getLogger(SignUpController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signup", method= RequestMethod.GET)
    public ModelAndView getSignUp() {
        logger.debug("Get ModelAndView in getSignUp()");

        ModelAndView modelAndView = new ModelAndView("signup/signup");
        modelAndView.addObject("signupForm", new User());
        logger.debug("Current ModelAndView - " + modelAndView);

        return modelAndView;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String postSignUp(@Valid @ModelAttribute("signupForm") User user, BindingResult result, Model model) {
        logger.debug("Receive SignUp form - " + user);
        logger.debug("POST model - " + model);

        if(result.hasErrors()) {
            logger.warn(result.toString());
            return "signup/signup";
        }

        userService.add(user);
        return "redirect:/homesignin";
    }
}
