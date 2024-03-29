package com.kh.app.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
// @controller + @ResponseBody
@RequestMapping("api/board")
@RequiredArgsConstructor
@CrossOrigin("*")
@Slf4j
public class BoardApiController {
	
	private final BoardService service;
	
	//게시글 목록 조회
	@GetMapping("list")
	public List<BoardVo> list() {
		

		log.info("BoardController 클래스의 list 메소드 호출됨");
		
//		String vo = "zzz";
//		String vo2 = "zzz";
//		String vo3 = "zzz";
		//이렇게하면 불필요한 연산을 줄일 수 있다..
//		log.info("전달받은 vo 값 : {}, 어떤 다른 값 : {}, 또 다른 값 : {}" , vo, vo2, vo3);
		
		return service.list();
	}
	
	//게시글 작성하기
	@PostMapping("write")
	public Map<String, String> write(@RequestBody BoardVo vo, HttpSession session) {
		Map<String, String> map = new HashMap<String, String>();
		int result = service.insert(vo);
		
		if(result ==1) {
			map.put("msg", "good");			
		}else {
			map.put("msg", "bad");
		}
		
		return map;
	}
	
}
