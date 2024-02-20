<%-- <%@page import="com.kh.app.home.vo.BoardVo"%> --%>
<%-- <%@page import="java.util.List"%> --%>

<!-- 임포트 uri주소 확실히 입력하기 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
//String x = (String) request.getAttribute("x");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>홈페이지~</h1>

	<h3>${x}</h3>

	<hr>

	<%-- 	${voList[0].title} 원하는 값 바로 꺼내는 방법--%>
	<table border="1">
		<tbody>
			<!-- 		EL사용해서 게시글 조회 -->
			<%-- 			<% List<BoardVo> voList = (List<BoardVo>) request.getAttribute("voList"); %> --%>
			<%-- 			<% for(BoardVo vo : voList){ %> --%>
			<%-- 			<% pageContext.setAttribute("vo", vo); %> --%>
			<!-- 			<tr> -->
			<%-- 				<td>${vo.title}</td> --%>
			<%-- 				<td>${vo.writer}</td> --%>
			<%-- 				<td>${vo.hit}</td> --%>
			<!-- 			</tr> -->
			<%-- 			<% } %> --%>

			<c:forEach items="${voList}" var="vo">
				<tr>
					<td>${vo.title}</td>
					<td>${vo.writer}</td>
					<td>${vo.hit}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

	<hr>
	
<%-- 	<c:if test="${loginMember != null}"> --%>
	<c:if test="${not empty loginMember}">
		<h3>이프문 통과했을 때 나오는 글자</h3>
	</c:if>
	
	<c:forEach begin="0" end="9" step="1" var="i">
		<h3>${i }</h3>
	</c:forEach>
	
</body>
</html>