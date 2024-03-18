package com.kh.app.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.app.board.vo.BoardVo;

@Controller
public class BoardController {

	//게시글 목록
	@GetMapping("board/list")
	public String getBoardList() {

		return "board/list";
		
	}
	
	//게시글 작성 (화면)
	@GetMapping("board/write")
	public String write() {
		return "board/write";
	}
	
	//게시글 작성
	@PostMapping("board/write")
	public String write(BoardVo vo) {
		
		//data	 	// 데이터 꺼내기 + 데이터 뭉치기
		
		//service 	// 데이터 가지고 비지니스 로직 처리 == 디비에 넣기 등...
		int result = 1;
		
		//result	// 처리한 결과를 클라이언트에게 알려주기 == 화면 만들어서 보여주기
		if(result == 1) {
			return "redirect:/board/list";
		}else {
			return "error";					// /WEB-INF/views/error.jsp로 포스팅 됨
		}
	}
	
	//게시글 수정 (화면)
	
	//게시글 수정
	
	//게시글 삭제
	
	//게시글 상세조회
}
