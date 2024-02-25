<%@page import="java.util.List"%>
<%@page import="com.kh.app.board.vo.CategoryVo"%>
<%@page import="com.kh.app.board.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	BoardVo vo = (BoardVo) request.getAttribute("vo");
	List<CategoryVo> categoryVoList = (List<CategoryVo>) request.getAttribute("categoryVoList");
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
		
		<form action="/app99/board/edit" method="post">
			<main>
				<h1>게시글 수정</h1>
				카테고리
				<select name="category">

					<% for(CategoryVo categoryVo : categoryVoList){ %>
						<%-- <% if( vo.getCategoryNo().equals(categoryVo.getNo()) ){ %>
							<option selected value="<%= categoryVo.getNo() %>"><%= categoryVo.getName() %></option>	
						<% }else{ %> --%>
							<option value="<%= categoryVo.getNo() %>"><%= categoryVo.getName() %></option>	
						<%-- <% } %> --%>
					<% } %>				
					
				</select>

				제목
				<input type="text" name="title" placeholder="제목을 입력하세요" value="<%= vo.getTitle() %>">

				내용
				<textarea name="content"><%= vo.getContent() %></textarea>

				<input type="submit" value="수정하기">
			</main>
			<input type="hidden" name="no" value="<%= vo.getNo() %>">`
		</form>
		
	</div>
	
	
	<script>
	
		function setOptionSelected() {
			const optionTagArr = document.querySelectorAll("main select option");
			for(let i = 0; i < optionTagArr.length; i++){
				const optionTag = optionTagArr[i];
				if(optionTag.value == <%= vo.getCategoryNo() %>){
					optionTag.selected = true;	
				} 
			}
		}
		
		setOptionSelected();
		
	</script>
	

</body>
</html>