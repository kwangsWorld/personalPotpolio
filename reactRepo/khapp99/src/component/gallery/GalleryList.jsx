import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import GalleryListItem from './GalleryListItem';
import { useNavigate } from 'react-router-dom';

const StyledGalleryListDiv = styled.div`
    width:100%;
    height:100%;
    display:grid;
    grid-template-columns: 1fr 1fr 1fr;
    grid-template-rows: 4.5fr 4.5fr 1fr;
    place-items: center center;
    & > button {
        grid-column: span 3;
        width: 100%;
    }
`;

const GalleryList = () => {

    const [arr, setArr] = useState([]);
    
    useEffect(() => {
        fetch("http://127.0.0.1:8888/app/api/gallery/list")
        .then( (resp) => {return resp.json()})
        .then( (data)=>{
            console.log(data);
            setArr(data.voList);
        } )
        ;   
    } , [] );

    
    const navigate = useNavigate();

    return (
        <>
            <StyledGalleryListDiv>
                {
                    arr.map( (vo) => {
                        return <GalleryListItem a={vo.title} b={vo.fullPath} />;
                    } )
                }
            <button onClick={ () => {
                navigate("/gallery/write");
            } }>작성하기</button>
            </StyledGalleryListDiv>
        </>
    );
};

export default GalleryList;