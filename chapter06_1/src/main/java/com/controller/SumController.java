package com.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bean.SumDTO;

@Controller
public class SumController {
	
	@RequestMapping(value="/input.do", method=RequestMethod.GET)
	public String input() { 
		return "sum/input";
	}	
	
//	@RequestMapping(value="/result.do", method=RequestMethod.GET)
//	public String result() { 
//		return "sum/result";
//	}	
	
	
//	@GetMapping(value="/result.do")
//	public ModelAndView result(@RequestParam int x ,
//							   @RequestParam int y) { 
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("x", x);
//		modelAndView.addObject("y", y);
//		modelAndView.addObject("sum", Integer.parseInt(x) + Integer.parseInt(y));
//		modelAndView.setViewName("sum/result");
//		
//		return modelAndView;
//	}	

	
//	@GetMapping(value="/result.do")
//	public ModelAndView result(@RequestParam (required = false, defaultValue = "0") String x ,
//							   @RequestParam (required = false, defaultValue = "0") String y) { 
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("x", x);
//		modelAndView.addObject("y", y);
//		modelAndView.setViewName("sum/result");
//		
//		return modelAndView;
//	}	
	
//	@GetMapping(value="/result.do")
//	public String result(@RequestParam Map<String, String> map, ModelMap modelMap) {
//		modelMap.put("x", map.get("x"));
//		modelMap.put("y", map.get("y"));
//		
//		return "sum/result";
//	}
	
	@GetMapping(value="/result.do")
	public String result(@ModelAttribute SumDTO sumDTO, Model model) {
		model.addAttribute("x", sumDTO.getX());
		model.addAttribute("y", sumDTO.getY());
		
		return "sum/result";
	}

}
