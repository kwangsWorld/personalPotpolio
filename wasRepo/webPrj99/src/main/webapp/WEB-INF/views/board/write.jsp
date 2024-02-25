<%@page import="java.util.List"%>
<%@page import="com.kh.app.board.vo.CategoryVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	List<CategoryVo> categoryVoList = (List<CategoryVo>)request.getAttribute("categoryVoList");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/app99/resources/css/board/write.css">
</head>
<body>

	<div id="wrap">
		
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		
		<form action="/app99/board/write" method="post">
			<main>
				<h1>게시글 작성</h1>
				카테고리
				<select name="category">
					<% for(CategoryVo categoryVo : categoryVoList){ %>
						<option value="<%= categoryVo.getNo() %>"><%= categoryVo.getName() %></option>	
					<% } %>
				</select>

				제목
				<input type="text" name="title" placeholder="제목을 입력하세요">

				내용
				<textarea name="content"></textarea>

				<input type="submit" value="작성하기">
			</main>
		</form>
		
	</div>

</body>
</html>