import React from 'react';
import styled from 'styled-components';

const StyledLoginAreaDiv = styled.div`
    width: 100%;
    height: 100%;
    background-color: white;
    border: 1px solid black;
    
    & > form {
        width:100%;
        height: 100%;
        display: grid;
        grid-template-rows: repeat(3, 1fr);
        grid-template-columns: 1fr 1fr;
        place-items: center center;

        & > input:nth-child(1) ,
        & > input:nth-child(2) {
            grid-column: span 2;
        }
        & > input{
            width:100%;
            height: 100%;
        }
    }
`;

const LoginArea = () => {
    return (
        <StyledLoginAreaDiv>
            <form action="/127.0.0.1:8888/app/member/login" method='post'>
                <input type="text" name='id' placeholder='아이디' />
                <input type="password" name='id' placeholder='비밀번호' />
                <input type="button" value="회원가입" />
                <input type="submit" value="로그인" />
            </form>
        </StyledLoginAreaDiv>
    );
};

export default LoginArea;
