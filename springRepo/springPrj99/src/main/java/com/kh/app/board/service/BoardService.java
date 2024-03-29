package com.kh.app.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardDao dao;
	private final SqlSessionTemplate sst;
	
	//게시글 작성
	public int insert(BoardVo vo) {
		
		return dao.insert(sst, vo);
	}

	//게시글 목록
	public List<BoardVo> list() {
		
		return dao.list(sst);
	}

	//게시글 상세 조회
	public BoardVo detail(BoardVo vo) {
		
		return dao.detail(sst, vo);
	}

	//게시글 삭
	public int delete(BoardVo vo) {
		return dao.delete(sst, vo);
	}

	//게시글 수정
	public int edit(BoardVo vo) {
		return dao.edit(sst, vo);
	}

}
