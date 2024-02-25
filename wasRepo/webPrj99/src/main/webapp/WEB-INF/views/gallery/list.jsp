<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

	main{
		width: 100%;
		height: 800px;
		display: grid;
		grid-template-rows: 1fr 7fr 2fr;
		grid-template-columns: 1fr;
	}

	#gallery-area{
		width: 100%;
		height: 100%;
		display: grid;
		grid-template-rows: 1fr 1fr;
		grid-template-columns: 1fr 1fr 1fr;
		place-items: center center;
	}

	#gallery-box{
		display: flex;
		flex-direction: column;
		justify-content: center;
		text-align: center;
	}

</style>

</head>
<body>

	<h1>${ galleryVoList }</h1>

	<div id="wrap">
		
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		
		<main>
			
			<div id="top-area">
				<button onclick="location.href='/app99/gallery/write'">작성하기</button>
			</div>

			<div id="gallery-area">
				<c:forEach items="${ galleryVoList }" var="vo">
					<div id="gallery-box">
						<img src="${ vo.src }" alt="${ vo.originName }">
						<span>${ vo.title }</span>
					</div>
				</c:forEach>
			</div>

			<div id="page-area">
				<a href="">1</a>
				<a href="">2</a>
				<a href="">3</a>
				<a href="">4</a>
				<a href="">5</a>
			</div>

		</main>
		
	</div>

</body>
</html>