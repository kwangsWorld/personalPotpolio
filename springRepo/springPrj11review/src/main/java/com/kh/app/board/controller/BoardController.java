package com.kh.app.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.kh.app.board.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired //스프링은 스프링 바구니에서 오토와이어드를 통해서 연결해주려고 하는데 연결 열쇠는 바로 타입임!
	private BoardService service;
	
	public BoardController() {
		System.out.println("컨트롤러 객체 생성됨 ~");
	}
}
