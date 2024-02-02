function f02(){
    console.log("f02 called...");
}

window.onload = () => {


    const btn03 = document.querySelector("#btn03")
    btn03.addEventListener('click' , () => {
    console.log("f03 called...");
    });

    const btn01 = document.querySelector("#btn01");
    btn01.onclick = () => {
        console.log("f01 called...");
    };

};
//onload가 2개이면 중첩되어 갱신되기 때문에 전에 있던 onload가 실행안됨.


function f04(){
    alert("a태그 클릭ㅋㅋ 네이버로 이동???");
}

function f05(){

    const memberIdInput = document.querySelector('input[name=memberId]');
    const memberPwdInput = document.querySelector('input[name=memberPwd]');
    const memberPwd2Input = document.querySelector('input[name=memberPwd2]');
    const memberNickInput = document.querySelector('input[name=memberNick]');

    if(memberIdInput.value.length < 1){
        alert("아이디는 빈칸일 수 없습니다.");
        memberIdInput.focus();
        return false;   //회원가입 ㄴㄴ 아이디 이상함
    }

    if(memberPwdInput.value.length < 1){
        alert("패스워드는 빈칸일 수 없습니다.");
        return false;
    }

    if(memberPwd2Input.value.length < 1){
        alert("패스워드 확인은 빈칸일 수 없습니다.");
        return false;
    }

    if(memberNickInput.value.length < 1){
        alert("닉네임은 빈칸일 수 없습니다.");
        return false;
    }

    if(memberPwdInput.value !== memberPwd2Input.value){
        alert("비밀번호 & 비밀번호확인 을 동일하게 작성하세요");
        return false;
    }


    return true;    //회원가입 진행
}