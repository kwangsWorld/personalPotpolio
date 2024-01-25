
function f01(){
    arr01 = new Array();
    arr02 = new Array(3);
    arr03 = new Array("핸드폰", "페브리즈", 100, true, null);
    arr04 = ["핸드폰", "페브리즈", 100, true, null];
    arr05 = [];
    arr05[0] = '하나';
    arr05[1] = '둘';
    arr05[7] = '셋';

    console.log(arr01);
    console.log(arr02);
    console.log(arr03);
    console.log(arr04);
    console.log(arr05);
}

// f01();

function f02(){
    const arr = ["하나", "둘", "셋", "넷", "다섯"];

    // indexOf()   배열에서 요소가 위치한 인덱스를 반환한다.
    // const x = arr.indexOf("파인애플");
    // console.log(x);

    // concat()    여러 개의 배열을 결합하여 새로운 배열을 리턴한다.
    const arr2 = ["귤", "감귤", "타이벡감귤"];
    const arr3 = ["사과", "배", "딸기"];
    let arr4 = [];
    arr4 = arr2.concat(arr3); 
    console.log(arr4);

    // join()      배열의 요소들을 결합해서 하나의 문자열로 반환한다.
    let str = arr2.join();
    console.log(str);
    
    // reverse()   원본 배열의 순서를 뒤집는 메소드이다.
    arr2.reverse();
    console.log(arr2);

    console.log('----');

    // sort()      배열을 오름차순(문자기준)으로 정렬하는 메소드이다.
    arr2.sort();
    console.log(arr2);
    
    // push()      배열의 맨 뒤에 요소를 추가한다.
    // const x = arr.push("샤인머스캣");
    // console.log(x);
    // arr2.push('오렌지');
    // console.log(arr2);
    
    // pop()       배열의 맨 뒤에 요소를 반환 후 제거한다.
    const a = arr.pop();
    const b = arr.pop();
    const c = arr.pop(); 
    console.log(a);
    console.log(b);
    console.log(c);
    console.log(arr);

    // shift()     배열의 맨 앞의 요소를 반환 후 제거한다.
    ex = arr2.shift();
    console.log(ex);
    console.log(arr2);

    // unshift()   배열의 맨 앞의 요소를 추가한다.
    arr2.unshift('감귤');
    console.log(arr2);
    console.log('----');
    
    // slice()     배열의 요소를 뽑아내는 메소드이다.
    ex = arr2.slice(0,1);
    console.log(ex, arr2)

    // // splice()    배열의 특정 인덱스 위치에 요소 제거 및 추가하는 메소드이다.
    // const x = arr.splice(3,2,'zzz');
    // console.log(x);

}

f02();