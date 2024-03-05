import React from 'react';
import { Link } from 'react-router-dom';
import styled from 'styled-components';

const StyledNaviDiv = styled.div`
    width: 100%;
    height: 100%;
    display:grid;
    grid-template-columns: 1fr;
    grid-auto-columns: 1fr;
    grid-auto-flow: column;
    place-items: center center;
    background: black;
    color: white;
    font-size: 2rem;
    border-top: 5px solid white;
`;


const Navi = () => {
    return (
        <StyledNaviDiv>
            <div><Link to="/board/list">게시판</Link></div>
            <div><Link to="/notice/list">공지사항</Link></div>
            <div><Link to="/gallery/list">갤러리</Link></div>
        </StyledNaviDiv>
    );
};

export default Navi;