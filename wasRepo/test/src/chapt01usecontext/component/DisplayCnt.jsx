import React, { useContext } from 'react';
import { CntContext, useCntContext } from '../context/CntContext';

const DisplayCnt = () => {

    const value = useCntContext(); //해당 컨텍스트에서 value를 가져옴

    return (
        <h1 onClick={ () => {
            console.log("디스플레이 카운트가 알고있는 value ::: " , value);
        }}>디스플레이 카운트 : {value.cnt}</h1>
    );
};

export default DisplayCnt;