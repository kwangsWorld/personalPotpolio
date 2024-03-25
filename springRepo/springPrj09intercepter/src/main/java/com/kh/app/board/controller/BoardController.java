package com.kh.app.board.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("board")
@Slf4j
public class BoardController {
	
	@GetMapping("write")
	public void write() {
		log.info("게시글 작성!");
	}

}
