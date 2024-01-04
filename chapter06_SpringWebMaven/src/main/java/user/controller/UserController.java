package user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import user.bean.UserDTO;
import user.service.UserService;

//Controller는 다른 작업없이 요청-응답

@Controller
@RequestMapping(value="user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping(value="writeForm")
	public String writeForm() {
		return "user/writeForm";
	}
	
	@GetMapping(value="list")
	public String list(@RequestParam (required = false, defaultValue = "1") String pg, Model model) {	
		model.addAttribute("pg", pg);
		
		return "user/list";
	}
	
	@PostMapping(value="write")
	@ResponseBody
	public void write(@ModelAttribute UserDTO userDTO) {
		userService.write(userDTO);
	}
	
	@PostMapping(value="getUserList")
	@ResponseBody
	public Map<String, Object> getUserList(@RequestParam String pg) {
		return userService.getUserList(pg);
	}
	
	@PostMapping(value="getUser")
	@ResponseBody
	public UserDTO getUser(@RequestParam String id) {
		return userService.getUser(id);
	}
	
	@PostMapping(value="isExist")
	@ResponseBody
	public String isExist(@RequestParam String id) {
		return userService.isExist(id);
	}
	
	@GetMapping(value="updateForm")
	public String updateForm() {
		return "user/updateForm";
	}
	
	@PostMapping(value="update")
	@ResponseBody
	public void update(@ModelAttribute UserDTO userDTO) {
		userService.update(userDTO);
	}
	
	@GetMapping(value="deleteForm")
	public String deleteForm() {
		return "user/deleteForm";
	}
	
	@PostMapping(value="delete")
	@ResponseBody
	public int delete(@RequestParam String id, @RequestParam String pwd) {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pwd", pwd);
		
		return userService.delete(map);
	}
}
