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

	private final SqlSessionTemplate sst;
	private final BoardDao dao;
	
	//게시글 작성
	public int insert(BoardVo vo) {
		return dao.insert(sst, vo);	
	}
	//게시글 목록 조회
	public List<BoardVo> getBoardList() {
		return dao.getBoardList(sst);
	}

	//게시글 상세 조회
	public BoardVo getBoardByNo(String no) {
		return dao.getBoardByNo(sst, no);
	}
	
	//게시글 삭제
	public int delete(String no) {
		return dao.delete(sst, no);
	}
	
	//게시글 수정
	public int edit(BoardVo vo) {
		return dao.edit(sst, vo);
	}

}
