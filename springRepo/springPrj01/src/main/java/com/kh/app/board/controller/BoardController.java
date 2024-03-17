package com.kh.app.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.app.board.vo.BoardVo;

@Controller
public class BoardController {

	@Autowired
	//게시글 목록
	@GetMapping("board/list")
	public String getBoardList() {
		return "board/list";
	}
	
	//게시글 작성하기 화면
	@GetMapping("board/write")
	public String insertBoard() {
		return "board/write";
	}
	
	//게시글 작성하기 처리
//	@PostMapping("board/write")
	public void insertBoard(BoardVo vo) {
		
//		//data
//		String title = req.getParameter("title");
//		String content = req.getParameter("content");
//		String writer = req.getParameter("writer");
		
//		BoardVo vo = new BoardVo();
//		vo.setTitle(title);
//		vo.setContent(content);
//		vo.setWriter(writer);
		
		System.out.println(vo);
		
	}
		
	
}	
