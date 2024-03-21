package com.kh.app.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.board.vo.BoardVo;

@Repository
public class BoardDao {

	//게시글 작성
	public int insert(SqlSessionTemplate sst, BoardVo vo) {
		//SQL
		return sst.insert("BoardMapper.insertBoard", vo);
		
	}

	//게시글 목록 조회
	public List<BoardVo> getBoardList(SqlSessionTemplate sst) {
		return sst.selectList("BoardMapper.getBoardList");
	}

	public BoardVo getBoardByNo(SqlSessionTemplate sst, String no) {
		return sst.selectOne("BoardMapper.getBoardByNo", no);
	}

	public int delete(SqlSessionTemplate sst, String no) {
		return sst.delete("BoardMapper.deleteBoardByNo", no);
	}

	public int edit(SqlSessionTemplate sst, BoardVo vo) {
		return sst.update("BoardMapper.setBoardByNo", vo);
	}
	
	

}
