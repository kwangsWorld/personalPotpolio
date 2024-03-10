import React from 'react';
import DisplayCnt from './DisplayCnt';
import PlusCnt from './PlusCnt';
import MinusCnt from './MinusCnt';
import { CntContextProvider } from '../context/CntContext';

const Main = () => {

    return (
        <>
            <CntContextProvider>
                <DisplayCnt/>
                <PlusCnt/>
                <MinusCnt/>
            </CntContextProvider>
        </>
    );
};

export default Main;