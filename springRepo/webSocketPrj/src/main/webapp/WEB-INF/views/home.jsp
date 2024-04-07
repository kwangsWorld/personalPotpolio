<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   <h1>채팅 ~~~</h1>
   
   <form id="formTag">
      <input type="text" name="msg">
      <input type="submit" value="전송">
   </form>
   
   <div id="msgArea"></div>
   
   <script>
      
      const ws = new WebSocket("ws://127.0.0.1:8888/app/chatserver");
      
      ws.onopen = () => { console.log("open~~~!!!"); };
      ws.onclose = () => { console.log("close~~~!!!"); };
      ws.onerror = () => { console.log("error~~~!!!"); };
      ws.onmessage = (msgEvent) => { 
         console.log("서버한테 메시지 받음 ~~~ msg~~~!!!");
         console.log(msgEvent.data);
         const msgArea = document.querySelector("#msgArea");
         msgArea.innerHTML += "<h3>" + msgEvent.data +"</h3>"
      };
      
      const formTag = document.querySelector("#formTag");
      formTag.addEventListener("submit", (event) => {
         event.preventDefault();
         
         //웹소켓 이용해서 메세지 보내기
         const inputTag = document.querySelector("input[name=msg]");
         ws.send(inputTag.value);
      });

      
      
   
   </script>

</body>
</html>






