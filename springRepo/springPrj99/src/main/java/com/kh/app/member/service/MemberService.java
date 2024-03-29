package com.kh.app.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberDao dao;
	private final SqlSessionTemplate sst;
	
	//회원가입
	public int join(MemberVo vo) throws Exception{
		
		String id = vo.getId();
		if(id.length() < 4) {
			throw new Exception("아이디가 너무 짧음");
		}
		
		if("admin".equalsIgnoreCase(id)) {
			throw new Exception("사용 불가한 아이디");
		}
		
		return dao.join(sst, vo);
		
	}

	// 로그인
	public MemberVo login(MemberVo vo) {
		
		return dao.login(sst,vo);
	}

	public int quit(MemberVo vo) {
		
		return dao.quit(sst, vo);
	}

	//회원 목록 조회
	public List<MemberVo> list() {
		
		return dao.list(sst);
	}

	//회원 정보 수정
	public int edit(MemberVo vo) {
		
		return dao.edit(sst, vo);
	}

}
