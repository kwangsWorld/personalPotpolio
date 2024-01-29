function f01(){
    //open
    // window.open("https://www.naver.com", "abc", "width=300, height=300");
    //  네이버를 ABC로 열겠다는 뜻, 버튼 여러번 눌러도 같은 창에서 열림

    // setTimeout
    // window.setTimeout( () => {
    //     console.log("3초 지났음~~");
    // } , 3000);


    //setInterval
    // window.setInterval( () => {
    //     console.log("인터벌 ~~~");
    // } , 3000);


    const abcTab = window.open("https://www.naver.com" , "abc");
    
    const closeTimer = window.setTimeout( () => {
        abcTab.close();
    }, 3000);

    clearTimeout(closeTimer);
    // clearInterval(타이머)
}

function f02(){
    
    // console.log(location);

    // location.href = "https://www.naver.com";

    // location.reload();


}

function f03(){
    
    console.log(history);
    // history.forward();
    // history.back();
    // history.go(-2); 양수면 앞으로 몇번, 음수면 뒤로 몇번

}

function f04(){
    console.log(navigator);
    console.log(screen);
}