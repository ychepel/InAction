package com.univer.inaction.controller;

import com.univer.inaction.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@SessionAttributes("username")
public class SignInController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signin")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("signin/signin");
        return modelAndView;
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public String postSignIn(@RequestParam String inputName,
                             @RequestParam String inputPassword,
                             Model model,
                             RedirectAttributes redirectAttributes) {
        log.debug("Authentification parameters username = " + inputName + "; password=" + inputPassword);
        if(userService.contains(inputName, inputPassword)) {
            model.addAttribute("username", inputName);
            return "redirect:/";
        }
        else {
            redirectAttributes.addAttribute("error", "authentication error");
            return "redirect:/signin";
        }
    }
}
