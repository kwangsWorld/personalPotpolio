import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';

const StyledHeaderDiv = styled.div`
    width: 100%;
    height: 100%;
    display: grid;
    grid-template-columns: 1fr 3fr 1fr;
    grid-template-rows: 1fr;
    & > .logoArea {
        background-image: url(https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQruegjqWdTDjJzpPailUT4oWCDcI2aosqqnw&usqp=CAU);        background-repeat: no-repeat;
        background-size: 50%;
        background-position: center center;
    }
`;

// MEMBER > login 관련
const StyledLoginAreaDiv = styled.div`
    width: 100%;
    height: 100%;
    & > form {
        width: 100%;
        height: 100%;
        display: grid;
        grid-template-columns: 1fr 1fr;
        grid-template-rows: repeat(3 , 1fr);
        place-items: center center;
        & > input {
            width: 100%;
            height: 100%;
        }
        & > input:nth-child(1),
        & > input:nth-child(2) {
            grid-column: span 2;
        }
    }
`;

const Header = () => {
    
    const navigate = useNavigate();

    const jsonStr = sessionStorage.getItem("loginMemberVo");
    const sessionLoginMemberVo = JSON.parse(jsonStr);
    const [loginMemberVo, setLoginMemberVo] = useState(sessionLoginMemberVo);


    const handleClickJoin = () => {
        navigate('/member/join');
    }

    const [vo, setVo] = useState();

    const handleInputChange = (event) => {
        // const name =  event.target.name;
        // const value = event.target.value;
        const {name, value} = event.target;

        setVo({
            ...vo ,
            [name]: value
        });
    }

    const handleClickLogin = (event) => {
        
        event.preventDefault();

        fetch("http://127.0.0.1:8888/app/rest/member/login" , {
            method: "POST",
            headers : {
                "Content-Type" : "application/json",
            },
            body : JSON.stringify(vo) ,
        })
        .then( (resp) => { return resp.json() } )
        .then( (data) => { 
            if(data.msg === "good"){
                alert("로그인 성공 !");
                sessionStorage.setItem("loginMemberVo", JSON.stringify(data.loginMemberVo)); 
                setLoginMemberVo(data.loginMemberVo);
                //sessionStorage는 문자열만 저장되기 때문에 JSON 형태의 문자열로 변환 후 보내기
                console.log("loginMemberVo", loginMemberVo);
            }else{
                alert("로그인 실패...");
            }
         } )
        .catch( (e) => {console.log(e);})
        .finally( () => {console.log("로그인 fetch 끝 ~~~");})
        ;
    }


    return (
        <StyledHeaderDiv>
            <div>빈칸</div>
            <div className='logoArea' onClick={ () => { navigate("/")}}></div>
            {
                loginMemberVo === null 
                ?
                <StyledLoginAreaDiv>
                    <form onSubmit={handleClickLogin}>
                        <input type="text" name='id' placeholder='아이디' onChange={handleInputChange}/>
                        <input type="password" name='pwd' placeholder='패스워드' onChange={handleInputChange}/>
                        <input type="button" value="회원가입" onClick={ handleClickJoin} />
                        <input type="submit" value="로그인" />
                    </form>
                </StyledLoginAreaDiv> 
                :
                <div>
                    <h3>{loginMemberVo.nick} 님 환영합니다.</h3>
                    <button onClick={ () => {
                        // sessionStorage.clear(); 전부 다 지우는 방법
                        sessionStorage.removeItem("loginMemberVo");
                        setLoginMemberVo(null);
                    } }>로그아웃</button>
                </div>
            }
            
            
        </StyledHeaderDiv>
    );
};



export default Header;