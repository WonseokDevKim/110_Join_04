package com.feb.join.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feb.join.dao.MemberDao;

@Service
public class MemberService {
	@Autowired
	private MemberDao memberDao;
	
	/**
	 * 아이디 중복 체크
	 * @param id 사용자가 입력한 id (Controller로부터 받음)
	 * @return int 테이블 내 해당 id와 일치하는 row 수
	 */
	public int confirmId(String id) {
		return memberDao.confirmId(id);
	}
}
