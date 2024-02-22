package com.feb.join.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
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
}
