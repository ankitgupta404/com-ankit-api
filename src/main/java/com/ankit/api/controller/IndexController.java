package com.ankit.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	private final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@GetMapping("/")
	public String index() {
		String METHOD_NAME = "Index";
		logger.debug("Inside Method::" + METHOD_NAME);
		return "ajax";
		
	}

}