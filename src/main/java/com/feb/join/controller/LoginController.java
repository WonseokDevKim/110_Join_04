package com.feb.join.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.feb.join.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	/**
	 * 로그인(회원가입) 페이지 이동
	 * 
	 * @return ModelAndView login.jsp
	 */
	@GetMapping("/loginPage.do")
	public ModelAndView loginPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	/**
	 * 로그인
	 * @param params 사용자가 입력한 id, passwd
	 * @return ModelAndView login.jsp
	 */
	@PostMapping("/login.do")
	public ModelAndView login(@RequestParam HashMap<String, String> params) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		
		boolean result = loginService.login(params);
		if(result) {
			mv.addObject("resultMsg", "로그인 성공");
		} else {
			mv.addObject("resultMsg", "로그인 실패");
		}
		
		return mv;
	}
}
