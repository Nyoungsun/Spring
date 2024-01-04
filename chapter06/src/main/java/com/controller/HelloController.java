package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping(value="/hello.do", method=RequestMethod.GET)
	public ModelAndView hello() { //Spring Container에 의해 호출되는 Callback Method
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", "Hello Spring"); //request.setAttribute("result", "Hello Spring")와 같은 개념
		modelAndView.setViewName("/view/hello"); //파일명 지정
		
		return modelAndView;
	}	
	
	@RequestMapping(value="/hello2.do", method=RequestMethod.GET)
	public ModelAndView hello2() { //Spring Container에 의해 호출되는 Callback Method
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result2", "Hello2"); //request.setAttribute("result", "Hello Spring")와 같은 개념
		modelAndView.setViewName("/WEB-INF/view2/hello2"); //파일명 지정
		
		return modelAndView;
	}	
	
	@RequestMapping(value="/hello3.do", method=RequestMethod.GET)
	@ResponseBody //단순 문자열로 
	public String hello3() { //Spring Container에 의해 호출되는 Callback Method
		return "Welcome";    //Spring에서는 return type이 String이면 파일명으로 인식
	}	
	
}

/*
Callback Method: 어떤 이벤트에 의해 호출되는 메소드

http://localhost:8080/Context명(Project명)/hello.do 요청
DispatcherServlet 
	  ↕ HandlerMapping
HelloController.java
 */
