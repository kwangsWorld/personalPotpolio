package com.kh.app.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.board.vo.BoardVo;

@Repository
public class BoardDao {

	public int write(SqlSessionTemplate sst, BoardVo vo) {
		
		return sst.insert("BoardMapper.write", vo);
	}

	public List<BoardVo> selectList(SqlSessionTemplate sst) {
		return sst.selectList("BoardMapper.selectList");
	}

	public BoardVo selectOne(SqlSessionTemplate sst, String no) {
		return sst.selectOne("BoardMapper.selectOne", no);
	}

	public int delete(SqlSessionTemplate sst, String no) {
		return sst.delete("BoardMapper.delete", no);
	}

	public int edit(SqlSessionTemplate sst, BoardVo vo) {
		return sst.update("BoardMapper.edit", vo);
	}

}
