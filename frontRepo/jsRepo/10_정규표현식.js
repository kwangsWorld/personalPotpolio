window.onload = function(){

    const target = document.querySelector("#target");
    target.addEventListener("click" , function(x){
        
        const str = "010-1234-1234";
        const reg = /^[\d]{3}-[\d]{3,4}-[\d]{4}$/;

        //const result = str.replace(reg, "V");
        const result = reg.test(str);
        
        console.log(result);

    });

};