package com.kh.app.member.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("member")
@RequiredArgsConstructor
public class MemberController {

	private final MemberService service;
	
	//회원가입 (화면)
	@GetMapping("join")
	public String join() {
		return "member/join";
	}
	
	// 회원 가입
	@PostMapping("join")
	public String join(MemberVo vo) throws Exception{
		
		int result = service.join(vo);
		
		if(result != 1) {
			throw new Exception();
		}
		
		
		return "redirect:/home";
	}
	
	// 로그인
	@PostMapping("login")
	public String login(MemberVo vo, HttpSession session) throws Exception{
		
		MemberVo loginMember = service.login(vo);
		System.out.println(loginMember);
		
		if(loginMember == null) {
			throw new Exception("로그인 실패");
		}
		
		session.setAttribute("loginMember", loginMember);
		session.setAttribute("alertMsg", "로그인 성공 !");
		
		return "redirect:/home";
	}
	
	// 회원 정보 수정
	@PostMapping("edit")
	public String edit(MemberVo vo) throws Exception{
		int result = service.edit(vo);
		
		if(result != 1) {
			throw new Exception();
		}
		
		
		return "redirect:/home";
	}
	
	// 회원 탈퇴
	@GetMapping("quit")
	public String quit(MemberVo vo, HttpSession session) throws Exception{
		
		int result = service.quit(vo);
		
		if(result !=1) {
			throw new Exception();
		}
		
		session.removeAttribute("loginMember");
		session.setAttribute("alertMsg", "회원 탈퇴 완료");
		
		return "redirect:/home";
	}
	
	// 회원 목록 조회
	@GetMapping("list")
	public String selectMemberList(Model model) {
		List<MemberVo> voList = service.list();
		System.out.println(voList);
		model.addAttribute("memberVoList", voList);
		
		return "member/list";
	}
	
	// 로그 아웃
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home";
	}
	
	
}
