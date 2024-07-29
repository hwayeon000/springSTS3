package org.zerock.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class MainController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// WebDataBinder 활용하여 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@GetMapping("/ex03")
	public String ex03 (TodoDTO todo) {
		log.info("todo=" + todo);
		return "/home";
	}
	
	@GetMapping("/ex04")
	public String ex04 (SampleDTO dto, @ModelAttribute("page") int page) {
		
		log.info("DTO="+dto);
		log.info("page="+page);
		return "/ex04";
	}
	
	@GetMapping("/ex05")
	public @ResponseBody SampleDTO ex05 () {
		log.info("ex05....");
		SampleDTO dto = new SampleDTO();
		dto.setAge(20);
		dto.setName("홍길동");
		
		return dto;
	}
	
	
	@GetMapping("/")
	public String main() {
		log.info("main...");
		return "/home";
	}
	// 요청함수 메소드 -> 요청 주소 매핑
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "/home";
	}
	// 요약 
	@GetMapping("/welcome")
	public String welcome(SampleDTO dto) {
		log.info(""+ dto);
		return "/welcome";
	}
	@GetMapping("/greeting")
	public String greeting() {
		return "/greeting";
	}
}