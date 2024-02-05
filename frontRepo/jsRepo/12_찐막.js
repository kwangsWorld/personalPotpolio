// 버튼 클릭 시,
// 인풋태그의 id가 비어있으면 => 아이디를 입력하세요
//인풋태그의 id가 ADMIN 이면 =>사용불가한 아이디 입니다.
//아니면 => 사용 가능한 아이디 입니다.
//인풋태그 글자 지우기

// window.onload = function(){

// const btn = document.querySelector("#idDupCheckBtn");
// btn.addEventListener("click",function(){
//     const inputTag = document.querySelector("input[name=memberId]");
//     const str = inputTag.value;

//     if(str.length < 1){
//         alert("아이디를 입력하세요!");
//         return;
//     }

//     if(str === "admin" || str === "ADMIN"){
//         alert("사용 불가한 아이디입니다.");
//         inputTag.value = " ";
//         inputTag.classList.add("red");
//         return;
//     }

//     alert("사용 가능한 아이디입니다.");

// })

// }

// window.onload=function(){
//     const target = document.querySelector("#target");
//     target.addEventListener("click",function(event){
//         alert(123);
//     })
// }

// window.onload = function(){
//     const target = document.querySelector("#target");
//     target.addEventListener("click",function(event){
//         const divTag = event.target;
//         divTag.classList.toggle("red");
//     });
// }

// window.setInterval(function(){
//     const target = document.querySelector("#target");
//     target.click();
// }, 2000);

// window.onload = function(){
//     const fe = document.querySelector("#fe");
//     fe.checked = false;

//     const op = document.querySelector("#op");
//     op.selected = false;
// }

function toggleAside(){
    const aside = document.querySelector("aside.aside-left");
    aside.classList.toggle("active");
}
















