package com.univer.inaction.home;

import com.univer.inaction.TestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@Autowired
	private TestBean testBean;

	@RequestMapping(value = "/")
//	@ResponseBody
	public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("home/homeNotSignedIn");
        modelAndView.addObject("exceptionMessage", "Hello World!");
        return modelAndView;
	}

}
