package com.kh.app.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;

@Service
public class BoardService {

	@Autowired //이 객체는 null값이 아닐것이다. 스프링이 알아서 객체를 넣어줌..
	private BoardDao dao;
	
	@Autowired
	private SqlSessionTemplate sst;
	
//	@Autowired 나중에는 이러한 형태로 만들어 줄 것임.
//	public BoardService(BoardDao a, SqlSessionTemplate b) {
//		dao = a;
//		sst = b;
//	}

	//게시글 목록 조회
	public List<BoardVo> getBoardList() {

		return dao.getBoardList(sst);
	
	}

}
