<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>홈페이지</h1>
	
	<button onclick="f01()";>버튼ㅋㅋ</button>
	
	<script>
		
		function f01(){
			
			//서버한테 요청을 보내기 ,fetch("주소", 옵션) => 옵션은 선택
			fetch("http://127.0.0.1:8889/app17/test")
// 			.then( 데이터를 가공, 객체.text() )
// 			.then( 가공된 데이터로 하고싶은거ㄱㄱ)
			
			// fetch의 요청 결과가 promise가 나옴
			// promise의 실행 결과는 .then으로 알 수 있음
			.then( (resp) => { return resp.json()} )
			// 또 그 결과는 promise로 나옴ㅋㅋ
			// 또 .then으로 promise의 결과를 화살표 함수로 가지고 감
			.then( (x) => { 
				console.log(x);
				console.log(x.title);
				console.log(x.content);
				//자바에서 객체를 자바스크립트로 가져와서 마음껏 사용할 수 있게 되었음!
			} );
		}
	</script>
</body>
</html>