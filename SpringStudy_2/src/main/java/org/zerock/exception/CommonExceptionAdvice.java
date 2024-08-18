package org.zerock.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;

import lombok.extern.log4j.Log4j;

//스프링 컨트롤러에서 발생하는 예외를 처리하는 존재임을 명시
@ControllerAdvice
@Log4j
public class CommonExceptionAdvice {
    // AOP(Aspect Oriented Programming)를 이용하는 방식
    // 관점 지향 프로그래밍이라고 불린다. 관점 지향은 쉽게 말해 어떤 로직을 기준으로 
    // 핵심적인 관점, 부가적인 관점으로 나누어서 보고 그 관점을 기준으로 각각 모듈화하겠다는 것
	
	// 해당 메서드()가 들어가는 예외타입을 처리하겠다, 어노테이션 속성으로 클래스 타입을 지정할 수 있다.
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handle404(NoHandlerFoundException nfe) {
    	log.info("error 404");
        return "error_404";
    }
  
    // Exception.class는 모든 예외에 대한 사항
    @ExceptionHandler(Exception.class)
    public String exception(Exception ex, Model model) {
    	log.error("Exception......" + ex.getMessage());
	    model.addAttribute("exception", ex);
	    log.error(model);
	    return "error_page";
    }
    
}
