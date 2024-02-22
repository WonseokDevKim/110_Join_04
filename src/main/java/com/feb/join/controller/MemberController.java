package com.feb.join.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.feb.join.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	/**
	 * 아이디 중복 체크
	 * 
	 * @param memberId 사용자가 입력한 아이디
	 * @return int 테이블 내 해당 id와 일치하는 row 수
	 */
	@PostMapping(value = "/confirmId.do", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> confirmId(String memberId) {
		System.out.println("memberId : " + memberId);
		int cnt = memberService.confirmId(memberId);
		System.out.println("cnt : " + cnt);
		return new ResponseEntity<>(cnt+"", HttpStatus.OK);
	}
	
}
