package com.kh.app.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

import lombok.RequiredArgsConstructor;
import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping("board")
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService bs;
	
	
	@PostMapping("write")
	public void write(BoardVo vo) {
		
		int result = bs.write(vo);
		
		System.out.println("게시판 작성 result : " + result);
	}
	
	@GetMapping("list")
	public void selectList() {
		
		List<BoardVo> voList = bs.selectList();
		
		for (BoardVo vo : voList) {
			System.out.println(vo);
		}
	}
	
	@GetMapping("detail")
	public void selectOne(String no) {
		BoardVo vo = bs.selectOne(no);
		
		System.out.println(vo);
	}
	
	@GetMapping("delete")
	public void delete(String no) {
		int result = bs.delete(no);
		System.out.println("게시글 삭제 result : " + result);
	}
	
	@PostMapping("edit")
	public void edit(BoardVo vo) {
		int result = bs.edit(vo);
		System.out.println("게시글 수정 result : " + result);
	}
	
}
