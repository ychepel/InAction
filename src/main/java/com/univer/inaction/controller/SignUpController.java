package com.univer.inaction.controller;

import com.univer.inaction.entity.User;
import com.univer.inaction.service.UserService;
import com.univer.inaction.validator.UserUniqueValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@Slf4j
@SessionAttributes("username")
public class SignUpController {

    @Autowired
    private UserUniqueValidator userUniqueValidator;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signup", method= RequestMethod.GET)
    public ModelAndView getSignUp() {
        ModelAndView modelAndView = new ModelAndView("signup/signup");
        modelAndView.addObject("signupForm", new User());
        log.debug("Create ModelAndView - " + modelAndView);

        return modelAndView;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String postSignUp(@Valid @ModelAttribute("signupForm") User user,
                             BindingResult result,
                             Model model,
                             RedirectAttributes redirectAttributes) {
        log.debug("Receive SignUp form - " + user);
        log.debug("POST model - " + model);

        userUniqueValidator.validate(user, result);
        if(result.hasErrors()) {
            log.warn(result.toString());
            return "signup/signup";
        }

        userService.save(user);
        model.addAttribute("username", user.getName());
        return "redirect:/";
    }
}
