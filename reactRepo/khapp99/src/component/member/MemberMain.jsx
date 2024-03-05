import React from 'react';
import { Route, Routes } from 'react-router-dom';
import MemberJoin from './MemberJoin';
import MemberEdit from './MemberEdit';
import ErrorPageNotFound from '../error/ErrorPageNotFound';


const MemberMain = () => {
    return (
        <Routes>
            <Route path='/join' element={<MemberJoin />} />
            <Route path='/edit' element={<MemberEdit />} />
            <Route path='*' element={<ErrorPageNotFound />} />
        </Routes>
    );
};

export default MemberMain;