package user.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import user.bean.UserDTO;
import user.bean.UserImageDTO;
import user.service.UserService;

//Controller는 다른 작업없이 요청-응답

@Controller
@RequestMapping(value = "user")
public class UserController2 {
	@Autowired
	private UserService userService;

	@GetMapping(value = "uploadForm")
	public String uploadForm() {
		return "user/uploadForm";
	}
	
	@GetMapping(value = "uploadFormAJax")
	public String uploadFormAJax() { 
		return "user/uploadFormAJax";
	}

	// ------------- img 1개 -------------
//	@PostMapping(value = "upload", produces = "text/html; charset=UTF-8")
//	@ResponseBody
//	public String upload(@RequestParam MultipartFile img, 
//				         @ModelAttribute UserImageDTO userImageDTO,
//					     HttpSession httpSession) {
//		
//		String filePath = httpSession.getServletContext().getRealPath("/WEB_INF/storage");
//		System.out.println(filePath); //실제 폴더 주소 - D:\Study\web\Spring\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\chapter06_SpringWebMaven\WEB_INF\storage
//		
//		String fileName = img.getOriginalFilename();
//		System.out.println(fileName);
//		
//		//String vurtualFilePath = "D:/Study/web/Spring/chapter06_SpringWebMaven/src/main/webapp/WEB-INF/storage"; //가상 폴더 주소
//		
//		File file = new File(filePath, fileName); //파일 생성
//		//File file2 = new File(vurtualFilePath, fileName);
//
//		try {
//			//FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file2)); //파일 복사
//			img.transferTo(file); //파일 이동
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		userImageDTO.setImage(fileName);
//		//UserService → UserDAO → userMapper.xml
//		
//		return "<img src='../storage/" + fileName + "'width='300' height='300'/>";
//	}

	// ------------- img 2개 이상 -------------
//	@PostMapping(value = "upload", produces = "text/html; charset=UTF-8")
//	@ResponseBody
//	public String upload(@RequestParam MultipartFile[] img, @ModelAttribute UserImageDTO userImageDTO,
//			HttpSession httpSession) {
//
//		String filePath = httpSession.getServletContext().getRealPath("/WEB_INF/storage");
//		System.out.println(filePath); // 실제 폴더 주소 -
//										// D:\Study\web\Spring\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\chapter06_SpringWebMaven\WEB_INF\storage
//
//		String fileName;
//		File file;
//
//		if (img[0] != null) {
//			fileName = img[0].getOriginalFilename();
//			file = new File(filePath, fileName);
//
//			try {
//				img[0].transferTo(file);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//
//		if (img[1] != null) {
//			fileName = img[1].getOriginalFilename();
//			file = new File(filePath, fileName);
//
//			try {
//				img[1].transferTo(file);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		return " 등록 완료";
//	}

	// ------------- 한번에 여러개의 파일 선택 -------------
	@PostMapping(value = "upload", produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String upload(@RequestParam("img[]") List<MultipartFile> list, @ModelAttribute UserImageDTO userImageDTO,
			HttpSession httpSession) {

		String filePath = httpSession.getServletContext().getRealPath("/WEB-INF/storage");
		System.out.println(filePath);   // 실제 폴더 주소 - D:\Study\web\Spring\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\chapter06_SpringWebMaven\WEB_INF\storage

		String fileName;
		File file;
		
		List<String> imgList = new ArrayList<>();

		for (MultipartFile img : list) {
			fileName = img.getOriginalFilename();
			file = new File(filePath, fileName);
			//System.out.println(fileName);

			try {
				img.transferTo(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
			//DB
			imgList.add(fileName);
			userService.upload(userImageDTO, imgList);
			
		} //for
		return " 등록 완료";
	}
	
	@GetMapping(value = "imgList")
	public String imgList() {
		return "user/imgList";
	}
	
	@PostMapping(value = "getImgList")
	@ResponseBody
	public List<UserImageDTO> getImgList() {
		return userService.getImgList();
	}
}
