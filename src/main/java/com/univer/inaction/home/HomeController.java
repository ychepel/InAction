package com.univer.inaction.home;

import com.univer.inaction.TestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

	@Autowired
	private TestBean testBean;

	@RequestMapping(value = "/")
	public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("home/homeNotSignedIn");
		List<Integer> activities = Arrays.asList(1, 2, 5, 2, 3);
		modelAndView.addObject("activities", activities);
        return modelAndView;
	}

	@RequestMapping(value = "/homesignin", method = RequestMethod.GET)
	public ModelAndView getHomeSignIn() {
		ModelAndView modelAndView = new ModelAndView("home/homeSignedIn");
		return modelAndView;
	}

}
