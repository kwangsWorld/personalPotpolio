function Counter(){

    let x = 0;

    //userState();

    function plus(){
        x++;
        console.log("증가 완료된 x의 값: " + x);
    }

    return <>
    <h1>카운터 값 : {x} </h1>
    <button onClick={plus}>플러스</button>
    </>;
}

export default Counter;