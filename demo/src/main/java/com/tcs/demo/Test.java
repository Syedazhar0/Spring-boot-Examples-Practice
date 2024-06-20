package com.tcs.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {

	@RequestMapping("/")
	public String test() {
		return"text.html";
	}
}
