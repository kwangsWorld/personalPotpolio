import React from 'react';
import { Route, Routes } from 'react-router-dom';
import BoardList from './BoardList';
import BoardWrite from './BoardWrite';
import BoardEdit from './BoardEdit';
import BoardDetail from './BoardDetail';

const BoardMain = () => {
    return (
        <Routes>
            <Route path='list' element={<BoardList />}/>
            <Route path='write' element={<BoardWrite/>}/>
            <Route path='detail' element={<BoardDetail/>}/>
            <Route path='edit' element={<BoardEdit/>}/> 
        </Routes>
    );
};

export default BoardMain;