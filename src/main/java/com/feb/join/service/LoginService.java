package com.feb.join.service;

import java.util.HashMap;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.feb.join.dao.LoginDao;
import com.feb.join.dto.Member;
import com.feb.join.util.Sha512Encoder;

@Service
public class LoginService {
	
	@Autowired
	private LoginDao loginDao;
	/**
	 * 로그인
	 * ID 및 비밀번호 일치하는지 확인
	 * @param params 사용자가 입력한 ID, passwd
	 * @return true/false
	 */
	public boolean login(HashMap<String, String> params) {
		// 존재하는 ID인지 확인
		String memberId = params.get("memberId");
		Member member = loginDao.login(memberId);
		
		System.out.println(member);
		
		if(ObjectUtils.isEmpty(member)) {
			return false;
		}
		
		// 사용자가 입력한 비밀번호(평문)을 암호화하고,
		// 해당 ID의 비밀번호(암호문)과 비교
		String passwd = params.get("passwd");
		String encodeTxt = Sha512Encoder.getInstance().getSecurePassword(passwd);
		
		return StringUtils.pathEquals(member.getPasswd(), encodeTxt);
	}
}
