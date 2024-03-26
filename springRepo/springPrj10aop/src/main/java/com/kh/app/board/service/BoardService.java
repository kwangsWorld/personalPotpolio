package com.kh.app.board.service;

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
		System.out.println("서비스 시작 ~");
		int result = dao.write(sst, vo);
		System.out.println("서비스 종료 ~");
		return result;
	}
}
