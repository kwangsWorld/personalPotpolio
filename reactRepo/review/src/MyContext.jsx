import { createContext, useContext, useState } from "react";


const MyContext = createContext("초기값ㅋㅋ");

const useMyContext = () => {
    return useContext(MyContext);
}

const MyContextProvider = (props) => {

    const arr = useState(10);
    const data = arr[0];
    const setData = arr[1];

    const obj = {
        "data" : data,
        "setData" : setData
    }

    return  <MyContext.Provider value={obj}>
        {props.children}
    </MyContext.Provider>
}


export {MyContext, useMyContext, MyContextProvider};