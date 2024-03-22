package com.kh.app.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.member.vo.MemberVo;

@Repository
public class MemberDao {

	//회원 가입
	public int join(SqlSessionTemplate sst, MemberVo vo) {
		return sst.insert("MemberMapper.join", vo);
	}

	//회원 목록 조회
	public List<MemberVo> list(SqlSessionTemplate sst) {
		return sst.selectList("MemberMapper.list");
	}

	//회원 상세 조회
	public MemberVo detail(SqlSessionTemplate sst, String no) {
		return sst.selectOne("MemberMapper.detail", no);
	}

	
	//회원 삭제
	public int delete(SqlSessionTemplate sst, String no) {
		return sst.delete("MemberMapper.delete", no);
	}

	//회원 수정
	public int edit(SqlSessionTemplate sst, MemberVo vo) {
		return sst.update("MemberMapper.edit", vo);
	}

}
