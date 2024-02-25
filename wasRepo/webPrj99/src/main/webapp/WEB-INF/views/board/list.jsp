<%@page import="java.util.Map"%>
<%@page import="com.kh.app.page.vo.PageVo"%>
<%@page import="com.kh.app.board.vo.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	List<BoardVo> boardVoList = (List<BoardVo>) request.getAttribute("boardVoList");
    	PageVo pvo = (PageVo)request.getAttribute("pvo");
    	Map<String, String> searchMap = (Map<String, String>)request.getAttribute("searchMap");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/app99/resources/css/board/list.css">

</head>
<body>
	<div id="wrap">
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		<main>
			<h1>게시글 목록</h1>
			
			<div class="search-area">
				<form action="/app99/board/search" method="get">
					<select name="searchType">
						<option value="title">제목</option>
						<option value="content">내용</option>
					</select>
					<input type="text" name="searchValue" placeholder="검색할 내용을 입력하세요">
					<input type="submit" value="검색하기">
				</form>
			</div>
			
				
				<table border="1">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>조회수</th>
							<th>작성일시</th>
							<th>카테고리</th>
						</tr>
					</thead>
					<tbody>
			<% for(BoardVo vo : boardVoList){ %>
						<tr>
							<td><%= vo.getNo() %></td>
							<td><%= vo.getTitle() %></td>
							<td><%= vo.getWriterNick() %></td>
							<td><%= vo.getHit() %></td>
							<td><%= vo.getEnrollDate() %></td>
							<td><%= vo.getCategoryName() %></td>
						</tr>
			<% } %>
					</tbody>
				</table>

			<% if(loginMember != null){ %>
				<button onclick="location.href='/app99/board/write'">작성하기</button>
			<% } %>

			<div class="page-area">
			
				<% if(pvo.getStartPage() != 1){ %>
					<a href="/app99/board/list?pno=<%= pvo.getStartPage()-1 %>">이전</a>
				<% } %>
				
				<% for(int i = pvo.getStartPage() ; i <= pvo.getEndPage(); i++){ %>
					
					<% if( i == pvo.getCurrentPage() ){ %>
						<span><%= i %></span>
					<% }else{ %>
						<a href="/app99/board/list?pno=<%= i %>"><%= i %></a>
					<% } %>
					
				<% } %>
				
				<% if( pvo.getEndPage() != pvo.getMaxPage() ){ %>
					<a href="/app99/board/list?pno=<%= pvo.getEndPage()+1 %>">다음</a>	
				<% } %>
			
			</div>
		</main>
	</div>
</body>
</html>


<script>
	const trArr = document.querySelectorAll("main > table > tbody > tr");
	for(let i = 0 ; i < trArr.length; ++i){
		trArr[i].addEventListener('click' , handleClick);
	}

	function handleClick(event){
		const tr = event.currentTarget;
		const no = tr.children[0].innerText;
		location.href = '/app99/board/detail?no=' + no + '&currPage=<%= pvo.getCurrentPage() %>';	
	}
	
	<% if(searchMap != null){ %>
		function setSearchArea(){
			
			// 옵션태그 셋팅
			const optionTagArr = document.querySelectorAll(".search-area form option");
			const searchType = "<%= searchMap.get("searchType") %>";
			for(let i = 0; i < optionTagArr.length; ++i){
				if( optionTagArr[i].value === searchType ){
					optionTagArr[i].selected = true;
					break;
				}
			}
			
			// 인풋태그 셋팅
			const searchValueTag = document.querySelector(".search-area form input[name=searchValue]");
			searchValueTag.value = "<%= searchMap.get("searchValue") %>";
			
		}
		setSearchArea();
		
		function setPageArea(){
			const aTagArr = document.querySelectorAll(".page-area a");
			for(let i = 0 ; i < aTagArr.length; ++i){
				aTagArr[i].href = aTagArr[i].href.replace("list" , "search"); 
				aTagArr[i].href += "&searchType=<%= searchMap.get("searchType") %>";
				aTagArr[i].href += "&searchValue=<%= searchMap.get("searchValue") %>";
			}
		}
		setPageArea();
	<% } %>

	
	
	
	
	
</script>