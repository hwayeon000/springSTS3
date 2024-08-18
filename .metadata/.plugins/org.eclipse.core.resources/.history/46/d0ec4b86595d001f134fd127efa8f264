package org.zerock.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.http.HttpStatus;

import lombok.extern.log4j.Log4j;

@ControllerAdvice
@Log4j
public class CommonExceptionAdvice {
  @ExceptionHandler(NoHandlerFoundException.class)
      @ResponseStatus(HttpStatus.NOT_FOUND)
      public String handle404(NoHandlerFoundException nfe) {
          return "error_404";
      }
    
}
