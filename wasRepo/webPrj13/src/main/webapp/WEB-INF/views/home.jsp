
<%@page import="com.kh.app.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<%
		MemberVo vo = (MemberVo) session.getAttribute("userData");
		String x = "게스트";
		if(vo != null){
			x = vo.getMemberNick();		
		}
	%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
    </head>

    <body>
        <h1>홈페이지</h1>
        
        <h2> <%=x %>님 환영합니다.</h2>

        <hr>

        <a href="/app13/member/join">회원가입</a>
        <br>
        <a href="/app13/member/login">로그인</a>
        <br>
        <a href="/app13/member/quit">회원탈퇴</a>
        <br>
    </body>

    </html>