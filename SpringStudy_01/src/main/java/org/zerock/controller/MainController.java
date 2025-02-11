package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	// 요청함수 메소드 -> 요청 주소 매핑
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "/home";
	}
	
	// 요약 
	@GetMapping("/welcome")
	public String welcome() {
		return "/welcome";
	}
	@GetMapping("/greeting")
	public String greeting() {
		return "/greeting";
	}
}