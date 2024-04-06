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
	
	public int write(BoardVo vo) {
		
		return dao.write(sst, vo);
		
	}

	public List<BoardVo> selectList() {
		
		return dao.selectList(sst);
	}

	public BoardVo selectOne(String no) {
		
		return dao.selectOne(sst, no);
	}

	public int delete(String no) {
		
		return dao.delete(sst, no);
	}

	public int edit(BoardVo vo) {
		
		return dao.edit(sst, vo);
	}

}
