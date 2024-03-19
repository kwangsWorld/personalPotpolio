package com.kh.app.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService bs; 
	
	//게시글 목록
	@GetMapping("board/list")
	public String getBoardList(BoardVo vo){
		
		List<BoardVo> voList = bs.getBoardList();
		
		System.out.println(voList);
		return "board/list";
	}
	
	//게시글 작성(화면)
	@GetMapping("board/write")
	public String insertBoard(){
		return "board/write";
	}
	
	//게시글 작성(로직)
	@PostMapping("board/write")
	public void insertBoard(BoardVo vo) {
		System.out.println(vo);
	}

}
