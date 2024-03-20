package com.kh.app.board.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

import oracle.net.aso.m;

//@Controller
//@ResponseBody  //모든 메소드가 문자열로 응답을 하고자 할 때
@RestController //Controller + Responsebody
public class BoardController {

	private final BoardService bs;  //재할당 불가하게 만들기 
	
	@Autowired
	public BoardController(BoardService bs) { //자동으로 bs에 할당해주기 위해서, 스프링이 자동으로 호출하게 될 것임	
		this.bs = bs;
	}
	
	// 게시글 작성 
	@PostMapping("board/write")
	public HashMap<String, String> write(BoardVo vo) {
		
		int result = bs.write(vo);
		System.out.println("게시글 작성 result : " + result);
		
		HashMap<String, String> map = new HashMap<String,String>();
		map.put("msg", "gooooooooooooooooood~~!!!");
		
		return map;
		
	}
}
