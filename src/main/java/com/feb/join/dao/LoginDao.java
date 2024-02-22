package com.feb.join.dao;

import org.springframework.stereotype.Repository;

import com.feb.join.dto.Member;

@Repository
public interface LoginDao {
	public Member login(String memberId);
}
