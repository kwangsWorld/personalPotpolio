// const testBtn = document.querySelector("#testBtn");

// // testBtn.addEventListener("어떤이벤트", 함수() 절대 금지, ()있으면 리턴값이 발생하기 때문);
// testBtn.addEventListener("click",f01());

// function f01(){
//     alert("f01 called")
// }

//익명함수
// testBtn.addEventListener('click', function (){
//     alert("f01 실행~~~");

// });

//화살표함수 (arrow function)

// testBtn.addEventListener('click', () => {
//     alert('화살표 함수 실행 ~~~');
// });

//자동실행함수
/* 
(
    function hello(){
     alert("hello~~~");
    }
)();
*/

// 익명함수나 화살표 함수도 아래와 같이 변수에 담으면
// 언제든 재사용이 가능하다.
// const x = () => {};
// x()

// Not a Number = NaN
function testFunc(a,b){
   let temp = 0;
   for(let i = 0; i < arguments.length; ++i){
    temp += arguments[i];
   }
   alert(temp);
}

function testReturn(){
    const ffff = (str) => {alert(str);};

    return ffff;
}

function myFunc(){
    const x = testReturn();
    console.log(x);
    x('zzzzzzzzzz');
}