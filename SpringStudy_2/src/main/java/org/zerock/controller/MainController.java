package org.zerock.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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

	@GetMapping("/fileUpload")
	public void fileUpload () {
		log.info("fileUplodad");
	}
	
	@PostMapping("/uploadFilePost")
	public String uploadFilePost(ArrayList<MultipartFile> files) {
		files.forEach(file-> {
			log.info("----------------");
			log.info("name:" + file.getOriginalFilename());
			log.info("size:" + file.getSize());
		});
		return "/fileUpload";
	}
	
	@GetMapping("/ex04")
	public String ex04 (SampleDTO dto, @ModelAttribute("page") int page) {
		
		log.info("DTO="+dto);
		log.info("page="+page);
		return "/ex04";
	}
	
	@GetMapping("/ex05")
//	public @ResponseBody SampleDTO ex05 () {
	public ResponseEntity<String> ex05 () {
		log.info("ex05....");
		SampleDTO dto = new SampleDTO();
		dto.setAge(20);
		dto.setName("홍길동");
		
		String msg = "{\"name\":\"홍길동\"}";
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		// header에 Content-Type, HttpStatus 보내기 > 개발자 도구에서 확인 가능
		return new ResponseEntity<>(msg, header, HttpStatus.OK);
	}
	
	
	@GetMapping("/")
	public String main() {
		log.info("main...");
		return "/home";
	}
	/*
	 * public void index() { }
	 */
	// 함수명과 뷰네임이 같음 = void -> index.jsp로 이동함
	//하지만 return에 index 명시 추천!
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