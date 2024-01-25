function f01(){

    const x = {
        name : '피카츄' ,
        hp : 100 ,
        atk : 30 ,
        skill : () => {
            console.log("백만볼트!!!");
            // return undefined;
        }
    };

    console.log(x);
    console.log(x.name);
    console.log(x.hp);
    console.log(x.atk);
    console.log(x.skill()); // skill 함수의 리턴값이 없어서 undefined임 === return undefined와 같음
    // console.log();   이건 그냥 줄바꿈만 해주는거임

}

// f01();

function f02(){
    
    const x = {};

    // x.name = "사과";
    // x.price = 50000;

    // console.log(x);
    // console.log(x.name);
    // console.log(x.price);

    // 변수를 사용해서 접근하기 위한 방법
    x["name"] = "사과";
    x["price"] = 50000;

    console.log(x["name"]);
    console.log(x["price"]);
}

// f02();

function f03(){
    const x = {
        name : "갤럭시 퀀텀3" ,
        price : 100000 ,
        brand : "삼성",
        color : 'black'
    };

    for(temp in x){
        console.log(temp);
        console.log(x[temp]);
    }
}

// f03();

function f04(){

    const x = {
        name : "피카츄" ,
        hp : 100
    };

    delete(x.hp);
    console.log(x);
}

// f04();

function f05(){
    const student01 = {name : "심원용" ,score : 100};
    const student02 = {name : "심투용" ,score : 50};
    const student03 = {name : "심삼용" ,score : 90};
    const student04 = {name : "심사용" ,score : 80};
    const student05 = {name : "심오용" ,score : 100};

    const stdArr = [student01, student02, student03];

    stdArr.push(student04);
    stdArr.push(student05);

    // console.log(stdArr[0].name);
    // console.log(stdArr[1].name);
    // console.log(stdArr[2].name);
    // console.log(stdArr[3].name);
    // console.log(stdArr[4].name);

    // for(let i = 0 ; i < stdArr.length; ++i)
    //     console.log(stdArr[i].name);

    for(const idx in stdArr){
        console.log(stdArr[idx].name);
    }

}

f05();



