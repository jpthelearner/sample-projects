package com.jp.app_name.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorld {
	private static final Logger log = Logger.getLogger(HelloWorld.class);
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String showHelloWorld(ModelMap model) {
		log.info("showHelloWorld is called");
		model.addAttribute("message", "Hello World!");
		return "hello_world";
	}
	
	
}
