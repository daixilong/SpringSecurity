package com.xdl.exception;

import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
@Configuration
@ControllerAdvice
public class GlobalException {
   @ExceptionHandler(Exception.class)
   public String getException(Exception e,HttpServletRequest request,Model model){
  	  model.addAttribute("url", request.getRequestURI());
  	  model.addAttribute("method", request.getMethod());
  	  System.out.println("===="+request.getRequestURI());
  	  System.out.println("===="+request.getMethod());
  	  return "error";
   }
}
