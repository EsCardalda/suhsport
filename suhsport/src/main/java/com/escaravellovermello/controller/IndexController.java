package com.escaravellovermello.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.escaravellovermello.constant.ViewConstant;

@Controller
public class IndexController {
	public static final Log LOG = LogFactory.getLog(IndexController.class);
			
			
	@GetMapping("/index")
	public String showLoginForm() {
		return ViewConstant.INDEX;
	}
}
