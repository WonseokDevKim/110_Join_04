package com.feb.join.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao {
	public int confirmId(String id);
}
