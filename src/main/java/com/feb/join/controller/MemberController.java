package com.feb.join.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.feb.join.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	/**
	 * 아이디 중복 체크
	 * 
	 * @param memberId 사용자가 입력한 아이디
	 * @return ResponseEntity<String> 테이블 내 해당 id와 일치하는 row 수
	 */
	@PostMapping(value = "/confirmId.do", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> confirmId(String memberId) {
		System.out.println("memberId : " + memberId);
		int cnt = memberService.confirmId(memberId);
		System.out.println("cnt : " + cnt);
		return new ResponseEntity<>(cnt+"", HttpStatus.OK);
	}
	
	/**
	 * 회원 가입
	 * 
	 * @param params 사용자가 입력한 회원 가입 정보
	 * @return ModelAndView login.jsp
	 */
	@PostMapping("/join.do")
	public ModelAndView join(@RequestParam HashMap<String, String> params) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		int result = memberService.join(params);
		if(result == 1) {
			mv.addObject("resultMsg", "회원 가입 성공");
		} else {
			mv.addObject("resultMsg", "회원 가입 실패");
		}
		return mv;
	}
}
