package com.hybrid.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hybrid.mapper.MemberMapper;
import com.hybrid.model.Member;

public class MemberDao {

	MemberMapper memberMapper;
	
	//spring 주입DI
	public void setMemberMapper(MemberMapper mapper)
	{
		this.memberMapper = mapper;
	}
	
	
	public List<Member> selectAll() {
		return null;
	}

	//로그인 처리 부분
	public Member selectByEmailAndPassword(String email, String password) {
		Map<String, Object> emailAndPassword = new HashMap<String, Object>();
		emailAndPassword.put("email", email);
		emailAndPassword.put("password", password);
		
		return memberMapper.selectByEmailAndPassword(emailAndPassword);
	}

	public void insert(Member m) {
	}

	public void update(Member m) {
	}

	public void delete(Member m) {
	}
}
