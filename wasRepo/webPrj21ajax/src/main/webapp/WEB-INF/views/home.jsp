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

	<button onclick="loadData();">서버한테서 데이터 받아오기</button>
	<br>
	<button onclick="sendData();">서버로 데이터 보내기</button>

	<script>
		function loadData(){		//fetch함수 사용해서 ajax방식으로 요청보내고 응답받아오기, 비동기방식(화면이동없이 하는것)
			fetch("/app21/board/list")
			.then( (resp) => { return resp.json();})
			.then( (data) => {console.log(data);} );
		}
		
		function sendData(){
			
			const x = {
					str : "hello" , 				//str이라는 key값에 hello를 적어서 보내기
					title : "tttt01" ,
					content : "ccc01"
			};
			
	         fetch("/app21/test" , { 			//자바스크립트의 객체를 만들어서 보내는 것
	            method : "post" ,				//정확히는 요청을 보내는 것이 아닌 이런 작업을 하는 Promise 객체를 만들어주는 것임
	            body :	JSON.stringify(x)		//자바스크립트의 객체를 JSON문자열로 만들어줌
	         })
	         .then( resp => resp.json()  )		//프로미스객체가 성공했으면 이거 수행해, resp는 통로고 응답을 json형태로 받아온 것
	         .then( data => {console.log(data);} )
	         .catch( (  )=>{ console.log("catch 블럭 ~~~ !"); } )	//프로미스 객체가 실패했으면 이거 실행해
	         ;
	      }
		</script>
</body>
</html>