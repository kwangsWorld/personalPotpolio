package com.kh.app.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("member")
public class MemberController {
	
	private final MemberService service;
	
	@PostMapping("join")
	public Map<String, String> join(@RequestBody MemberVo vo){
		
		int result = service.join(vo);
		
		Map<String, String> map = new HashMap<String, String>();
		if(result == 1) {
			map.put("msg", "회원가입 성공!!!!!!");
		}else {
			map.put("msg", "회원가입 실패ㅠㅠ");
		}
		
		return map;
	}
	

}
