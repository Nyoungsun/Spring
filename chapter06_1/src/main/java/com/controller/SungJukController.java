package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bean.SungJukDTO;

@Controller
@RequestMapping(value="sungJuk")
public class SungJukController {

	@GetMapping(value="input.do")
	public String input() { 
		return "sungJuk/input";
	}	
	
	@PostMapping(value="result.do")
	public String result(@ModelAttribute SungJukDTO sungJukDTO, Model model) {
		int tot = sungJukDTO.getMath() + sungJukDTO.getKor() + sungJukDTO.getEng();
		double avg = (sungJukDTO.getMath() + sungJukDTO.getKor() + sungJukDTO.getEng()) / 3;
		
		sungJukDTO.setTot(tot);
		sungJukDTO.setAvg(avg);
		
		model.addAttribute("sungJukDTO", sungJukDTO);
		
		return "sungJuk/result";
	}
}
