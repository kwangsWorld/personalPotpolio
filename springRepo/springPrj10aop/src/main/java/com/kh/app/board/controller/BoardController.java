package com.kh.app.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

@Controller
public class BoardController {
	
	private final BoardService service;
	
	public BoardController(BoardService x) {
		this.service = x;
	}

//	@RequestMapping(value = "board/write", method = RequestMethod.POST) 아래랑 같은 코드
	@PostMapping("board/write")
	public void write(BoardVo vo) {
		System.out.println("컨트롤러 시작 ~");
		int result = service.write(vo);
		System.out.println("컨트롤러 종료 ~");
	}
}
