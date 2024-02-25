<%@page import="com.kh.app.board.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	BoardVo vo = (BoardVo)request.getAttribute("vo");
    	String currPage = (String)request.getAttribute("currPage");
    	if(currPage == null){
    		currPage = "1";
    	}
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/app99/resources/css/board/detail.css">
</head>
<body>

	<div id="wrap">
		
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		
		<main>
			<h1>게시글 상세조회</h1>
			
			<table border="1">
				<tbody>
					<tr>
						<td><%= vo.getTitle() %></td>
						<td><%= vo.getWriterNick() %></td>
					</tr>
					<tr>
						<td><%= vo.getEnrollDate() %></td>
						<td><%= vo.getHit() %></td>
					</tr>
					<tr>
						<td colspan="2"><%= vo.getContent() %></td>
					</tr>
				</tbody>
			</table>

			<% if(loginMember != null && loginMember.getNo().equals(vo.getWriterNo())){ %>
				<div class="btn-area">
					<button onclick="location.href='/app99/board/edit?no=<%= vo.getNo() %>'">수정</button>
					<button onclick="location.href='/app99/board/delete?no=<%= vo.getNo() %>'">삭제</button>
				</div>
			<% } %>
			
			<a href="/app99/board/list?pno=<%= currPage %>">목록으로</a>

			
		</main>
		
		댓글들 :::
		<div id="replyArea"></div>
		
	</div>
	
	<script>
			
		//ajax 를 이용하여 댓글 목록 조회
		function getReplyList(refNo){
			fetch("/app99/board/reply/list?refNo=" + refNo)
			.then( ( resp ) => { return resp.json(); } )
			.then( ( data ) => { console.log(data); } );
		}
		
		getReplyList(1);
		
// 		//댓글 목록들을 화면에 보여주기
// 		function setReplyArea(){
// 			const divTag = document.querySelector("#replyArea");
// 			const replyVoList = getReplyList(1);	// 변수를 이용해서 바꿔줄 예정 ...
// 			divTag.innerHTML = replyVoList;
// 		}
		
	
	</script>

</body>
</html>