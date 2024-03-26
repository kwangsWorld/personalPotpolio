package com.kh.app.board.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.board.vo.BoardVo;

@Repository
public class BoardDao {

	public int write(SqlSessionTemplate sst, BoardVo vo) {
		System.out.println("DAO 시작 ~ ");
		int result = 1; //실제로는 SQL 실행~~~
		System.out.println("DAO 종료 ~");
		return result;
	}

	
}
