package com.kh.app.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("rest/member")
@ResponseBody //요청들어오는거 body에 있는거 그대로 불러들여오겠다. 내 return값을 packet의 return값으로 받아주는 것..?
@RequiredArgsConstructor
@CrossOrigin("*") //CORS(Cross Origin Resource Security) 문제! 브라우저의 보안 정책임..
public class MemberRestController {
	
	private final MemberService service;
	
	@PostMapping("join")
	public Map<String, String> join(@RequestBody MemberVo vo) throws Exception{
		
		Thread.sleep(3000);
		
		System.out.println("fetch 통해서 받은 데이터 : " +  vo);
		int result = service.join(vo);
		
//		String str = "{\"result\" : \"1\"}";
		Map<String, String> map  = new HashMap<String, String>();
		if(result == 1) {
			map.put("msg", "good");
		}else {
			map.put("msg", "bad");
		}
		return map;
		
	}
	
	@PostMapping("login")
	public Map<String, Object> login(@RequestBody MemberVo vo) {
		MemberVo loginMember = service.login(vo);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("msg", "good");
		map.put("loginMemberVo", loginMember);
		if(loginMember == null) {
			map.put("msg", "bad");
		}
		return map;
	}
}
