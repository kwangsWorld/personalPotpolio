import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';

const StyledBoardListDiv = styled.div`
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    & > table {
        width: 80%;
        height: 80%;
        border: 3px solid black;
        margin: auto;
    }
    & > button {
        width: 30%;
        font-size: 2rem;
    }
`;

const BoardList = () => {

    console.log("BoardList 컴포넌트 렌더링 ~~~");

    const navigate = useNavigate();

    //fetch를 이용해서 데이터 준비
    const [boardVoList, setBoardVoList] = useState([]);
    const loadBoardVoList = () => {
        fetch("http://127.0.0.1:8888/app/api/board/list")
        .then( resp => resp.json() )
        .then( (x) => { setBoardVoList(x); } ) //위의 프로시져의 반환값
        ;
    }
    
    useEffect( () => {
        console.log("useEffect 호출됨 ~~~");
        loadBoardVoList();
    } , [] );




    // const boardVoList = [];
    // boardVoList[0] = {
    //     no : '1',
    //     title: 'title01',
    //     writer: 'writer01',
    //     hit: '777',
    //     enrollDate: new Date().toString(),
    // };
    // boardVoList[1] = {
    //     no : '2',
    //     title: 'title02',
    //     writer: 'writer02',
    //     hit: '888',
    //     enrollDate: new Date().toString(),
    // };
    // boardVoList[2] = {
    //     no : '3',
    //     title: 'title03',
    //     writer: 'writer03',
    //     hit: '999',
    //     enrollDate: new Date().toString(),
    // };

    // //반복문 연습
    // //반복문1
    // for(let i = 0; i < boardVoList.length; ++i){
    //    console.log(boardVoList[i]);
    // }
    
    // //반복문2  //리스트의 모든 요소를 순차적으로 가져와서 "함수 실행"
    // boardVoList.forEach( (x) => {console.log(x); } );

    // //반복문3  //배열의 모든 요소를 순차적으로 가져와서 "함수실행 결과값들로 새로운 배열 만들기"
    // const arr = boardVoList.map( (x) => {
    //     console.log(x);
    //     return <tr>
    //         <td>{x.no}</td>
    //         <td>{x.title}</td>
    //         <td>{x.writer}</td>
    //         <td>{x.hit}</td>
    //         <td>{x.enrollDate}</td>
    //     </tr>
    // } );
    // console.log(arr);

    console.log("return 직전 ~~~ (곧 렌더링-화면만들기 ");
    return (
        <StyledBoardListDiv>
            <table>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>조회수</th>
                        <th>작성일시</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        boardVoList.length === 0
                        ?
                        <h1>로딩중...</h1>
                        :
                        boardVoList.map( vo => <tr key={vo.no}>
                              {/*tr태그를 서로 구분하기 위해서    */}
                            <td>{vo.no}</td>
                            <td>{vo.title}</td>
                            <td>{vo.writer}</td>
                            <td>{vo.hit}</td>
                            <td>{vo.enrollDate}</td>
                        </tr>
                        )
                    }
                </tbody>
            </table>

            {
                <button onClick={ () => {
                    navigate("/board/write");
                }}>게시글 작성하기</button>
            }

        </StyledBoardListDiv>
    );
};

export default BoardList;