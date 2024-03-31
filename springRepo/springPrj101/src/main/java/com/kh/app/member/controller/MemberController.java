package com.kh.app.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@Controller
public class MemberController {
	
	@GetMapping("member/join")
	public String MemberJoin() {
		
		return "member/join";
		
	}
	
	@PostMapping("member/join")
	public void MemberJoin(MemberVo vo) {
		
		try {
			//데이터
			
			//서비스
			MemberService ms = new MemberService();
			int result = ms.MemberJoin(vo);
			
			//결과
			if(result != 1) {
				throw new Exception();
			}
			System.out.println("회원가입 성공");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("회원가입 실패");
		}
//		System.out.println(vo);
	}
}
