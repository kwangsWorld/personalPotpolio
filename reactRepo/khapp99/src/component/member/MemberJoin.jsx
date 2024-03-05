import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';

const StyledJoinDiv = styled.div`
    width: 100%;
    height: 100%;
    & > form {
        width: 100%;
        height: 100%;
        margin: auto;
        border: 5px dashed black;
        & > table {
            width: 100%;
            height: 100%;
            table-layout: fixed;
        }
    }

`;

const MemberJoin = () => {

    const navigate = useNavigate();

    let isFetching = false;
    const [vo, setVo] = useState({
        id: "", //키값은 존재하지만 값은 채워져있지 않음, 안써도 상관없음
        pwd: "",
        nick: ""
    });

    const handleInputChange = (event) => {
        // const value = event.target.value;
        // const name = event.target.name;
        const{name, value} = event.target;

        setVo({
            ...vo ,
            [name] : value
        })
    }

    //style을 제외한 것들은 대부분 컴포넌트 안에 있어야함
    const handleJoinSubmit = (event) => {

        event.preventDefault(); //기본동작 막아주기

        //해도되나? 검사
        if(isFetching){
            return;
        }

        //작업 시작
        isFetching = true;


        //vo 값 셋팅
        // setVo({
        //     id:"user01",
        //     pwd: "1234",
        //     nick: "nick01"
        // })

        fetch("http://127.0.0.1:8888/app/rest/member/join", { //promise 문법
            method:"post",
            headers:{
                "Content-Type": "application/json" //mime type json 
            }, 
            body: JSON.stringify(vo)
        })
        .then( resp => {
            if(!resp.ok){  //상태 코드 체크 (200번대 정상, 400번대 클라 잘못 500번대 서버 잘못)
                throw new Error("회원가입 fetch 실패..");
            }
            return resp.json();
        } )
        .then( data => {
            // console.log("서버한테 응답받은 data :::");
            // console.log(data);
            if(data.msg === "good"){
                alert("회원가입 성공 !");
                navigate("/");
            }else{
                alert("회원가입 실패 ...");
                navigate("/failpage~~~");
            }
        })
        .catch( (e) => {
            console.log(e);
            alert("회원가입 실패");
        } )
        .finally( ()=>{
            isFetching = false;
        } )
        ;
    }

    return (
        <StyledJoinDiv>
            <form onSubmit={ handleJoinSubmit }>
                <table>
                    <tbody>
                        <tr>
                            <td>아이디</td>
                            <td><input type="text" name='id' onChange={handleInputChange} /></td>
                        </tr>
                        <tr>
                            <td>패스워드</td>
                            <td><input type="password" name='pwd' onChange={handleInputChange} /></td>
                        </tr>
                        <tr>
                            <td>닉네임</td>
                            <td><input type="text" name='nick' onChange={handleInputChange}/></td>
                        </tr>
                        <tr>
                            <td><input type="reset" /></td>
                            <td><input type="submit" value="회원가입"/></td>
                        </tr>

                    </tbody>

                </table>

            </form>
        </StyledJoinDiv>

    );
};

export default MemberJoin;