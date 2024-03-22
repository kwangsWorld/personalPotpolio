package com.kh.app.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

	private final SqlSessionTemplate sst;
	private final MemberDao dao;
	
	//회원가입
	public int join(MemberVo vo) {
		int result =  dao.join(sst, vo);
//		int x = 1 / 0;
		return result;
	}

	//회원 목록 조회
	public List<MemberVo> list() {
		return dao.list(sst);
	}

	public MemberVo detail(String no) {
		return dao.detail(sst, no);
	}

	public int delete(String no) {
		return dao.delete(sst, no);
	}

	public int edit(MemberVo vo) {
		return dao.edit(sst, vo);
	}
	
	
}
