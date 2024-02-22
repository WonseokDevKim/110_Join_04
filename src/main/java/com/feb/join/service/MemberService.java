package com.feb.join.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feb.join.dao.MemberDao;
import com.feb.join.util.Sha512Encoder;

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
	
	/**
	 * 회원 가입 Service - 사용자가 입력한 암호(평문)을 암호화하고 Dao 호출
	 * 
	 * @param params 회원가입 정보
	 * @return int 가입 성공 시 1 반환
	 */
	public int join(HashMap<String, String> params) {
		// 사용자가 입력한 비밀번호(평문) 암호화
		String passwd = params.get("passwd");
		String encodeTxt = Sha512Encoder.getInstance().getSecurePassword(passwd);
		params.put("passwd", encodeTxt);
		
		return memberDao.join(params);
	}
}
