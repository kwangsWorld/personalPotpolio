<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>

	</head>

	<body>

		<div id="wrap">

			<%@ include file="/WEB-INF/views/common/header.jsp" %>

				<main>
					<h1 align="center">회원가입</h1>

					<form action="/app99/member/join" method="post" onsubmit="return checkValidate();">
						<table>
							<tbody>
								<tr>
									<td>* 아이디</td>
									<td><input type="text" name="memberId"></td>
									<td><input type="button" value="중복체크" onclick="checkIdDup();"></td>
								</tr>
								<tr>
									<td>* 비밀번호</td>
									<td><input type="password" name="memberPwd"></td>
								</tr>
								<tr>
									<td>* 비밀번호 확인</td>
									<td><input type="password" name="memberPwd2"></td>
								</tr>
								<tr>
									<td>* 닉네임</td>
									<td><input type="text" name="memberNick"></td>
								</tr>
								<tr>
									<td>전화번호</td>
									<td><input type="tel" name="phoneNumber"></td>
								</tr>
								<tr>
									<td>이메일</td>
									<td><input type="email" name="email"></td>
								</tr>
								<tr>
									<td>주소</td>
									<td><input type="text" name="addr"></td>
								</tr>
								<tr>
									<td>취미</td>
									<td>
										<label for="cb01">게임</label> <input id="cb01" type="checkbox" name="hobbys"
											value="game">
										<label for="cb02">요리</label> <input id="cb02" type="checkbox" name="hobbys"
											value="cook">
										<label for="cb03">운동</label> <input id="cb03" type="checkbox" name="hobbys"
											value="workout">
										<br>
										<label for="cb04">자바</label> <input id="cb04" type="checkbox" name="hobbys"
											value="java">
										<label for="cb05">자스</label> <input id="cb05" type="checkbox" name="hobbys"
											value="js">
										<label for="cb06">쿼리</label> <input id="cb06" type="checkbox" name="hobbys"
											value="js">
									</td>
								</tr>
								<tr>
									<td colspan="2"><input type="submit" value="회원가입" style="width: 100%;"></td>
								</tr>

							</tbody>
						</table>
					</form>
				</main>
		</div>
	</body>

	</html>

	<script>

		function checkValidate() {
			//중복검사 통과 여부
			if(!window.idOk){
				alert("아이디 중복검사를 완료하세요");
				document.querySelector("main input[name=memberId]").focus;
				return false;
			}

			//아이디 길이
			const memberId = document.querySelector("main input[name=memberId]").value;
			const memberIdRegex = /^[a-z0-9]{4,12}$/;
			if (!memberIdRegex.test(memberId)) {
				alert("아이디를 올바르게 입력하세요");
				document.querySelector("input[name=memberId]").focus();
				return false;
			}

			//패스워드 일치여부
			const memberPwd = document.querySelector("main input[name=memberPwd]").value;
			const memberPwd2 = document.querySelector("main input[name=memberPwd2]").value;

			if (memberPwd !== memberPwd2) {
				alert("비밀번호가 일치하지 않습니다.");
				document.querySelector("main input[name=memberPwd]").focus();
				return false;
			}

			//패스워드 길이
			if (memberPwd.length < 4) {
				document.querySelector("main input[pwd=memberPwd]").focus();
				alert("비밀번호는 4글자 이상이어야 합니다.");
				return false;
			}

			//닉네임 부적절한 단어 없는지
			const memberNick = document.querySelector("main input[name=memberNick]").value;
			if (memberNick.includes("admin")) {
				document.querySelector("main input[name=memberNick]").focus();
				alert("부적절한 닉네임입니다.");
				return false;
			}
			//이메일 형식 맞는지 (정규식)
			//전화번호 형식 맞는지 (정규식)
			// if (문제있음) {
			// 	alert('~~~문제가 있음');
			// 	return false;
			// }

			return true;
		}
		
		//아이디 중복체크
		function checkIdDup(){
			
			const memberIdValue = document.querySelector("main input[name=memberId]").value;
			
			fetch("/app99/member/check/id?memberId=" + memberIdValue)
			//fetch 옵션설정 안했기 때문에 기본 옵션인 GET방식임
			.then( (resp) => { return resp.json() } )
			.then( (data) => {
				const result = data.msg
				const isOk = result === "ok";
				if(isOk){
	 				alert("사용가능");
	 				window.idOk = true;
	 			}else{
	 				alert("사용불가");
	 				window.idOk = false;
	 			}
			})
			
// 			const isOk = 서버한테 물어보기;
// 			if(isOk){
//  				alert("사용가능");
//  			}else{
//  				alert("사용불가");
//  			}

		}
		
		
</script>