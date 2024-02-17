package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/join")
public class MemberJoinController extends HttpServlet{

	//회원가입 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);
	}
	
	//회원가입 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			//data
			String memberId = req.getParameter("memberId");
			String memberPwd = req.getParameter("memberPwd");
			String memberPwd2 = req.getParameter("memberPwd2");
			String memberNick = req.getParameter("memberNick");
			
			MemberVo vo = new MemberVo();
			
			vo.setMemberId(memberId);
			vo.setMemberPwd(memberPwd);
			vo.setMemberPwd2(memberPwd2);
			vo.setMemberNick(memberNick);
			
			//service
			MemberService ms = new MemberService();
			int result = ms.join(vo);
			
			//result (==view 결과에 따라 뷰페이지 만든다는 뜻)
//			if(result == 1) {
//				req.getRequestDispatcher("/WEB-INF/views/common/success.jsp").forward(req, resp);
//			}else {
//				throw new Exception();
//			}
			
			if(result != 1) {
				throw new Exception();
			}
			req.getRequestDispatcher("/WEB-INF/views/common/success.jsp").forward(req, resp);
			
		}catch(Exception e) {
			System.out.println("회원가입 중 에러 발생 ...");
			e.printStackTrace();
			req.getRequestDispatcher("/WEB-INF/views/common/fail.jsp").forward(req, resp);
		}
	}
	
	//회원가입 데이터
}
