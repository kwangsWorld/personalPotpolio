import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';

const StyledBoardWriteDiv = styled.div`
    width:100%;
    height:100%;
    & > form{
    display: flex;
    justify-content: center;
    align-items: center;
    }
`;


const BoardWrite = () => {

    const str = sessionStorage.getItem("loginMemberVo");
    const vo = JSON.parse(str);
    const writerNo = vo.no;
    
    const [inputBoardVo, setInputBoardVo] = useState({
        "writerNo" : writerNo,
    });
    const navigate = useNavigate();

    const handleSubmit = (event) => {
        event.preventDefault();


        fetch("http://127.0.0.1:8888/app/api/board/write", {
            method: "POST",
            headers : {
                "Content-Type" : "application/json",
            },
            body : JSON.stringify(inputBoardVo) ,
            //여기에 담아서 server에 import해줘
        })
        .then( (resp) => {return resp.json();} )
        .then( (data) => {
            if(data.msg === "good"){
                alert("게시글 작성 성공 !");
                navigate("/board/list");
            }else{
                alert("게시글 작성 실패 ...");
                navigate("/");
            }
        } )
        .catch( (e) => {
            alert("게시글 작성 에러발생");
        })
    };

    const handleChangeInput = (event) => {
        const {name, value} = event.target;

        setInputBoardVo({
           ...inputBoardVo ,
           [name]:value,
        }); 

    }
    
    return (
        
        <StyledBoardWriteDiv>
            <form onSubmit={handleSubmit}>
                <table>
                    <tbody>
                        <tr>
                            <td>제목</td>
                            <td><input type="text" name='title' onChange={handleChangeInput}/></td>
                        </tr>
                        <tr>
                            <td>내용</td>
                            <td><textarea name="content" onChange={handleChangeInput}></textarea></td>
                        </tr>
                        <tr>
                            <td colSpan="2"><input type="submit" value="작성하기" /></td>
                            <td></td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </StyledBoardWriteDiv>
    );
};

export default BoardWrite;