import styled from 'styled-components';
import React from 'react'


const StyledSectionDiv = styled.div`
    width:100%;
    height:100%;
    background-color: lightgreen;

    & > table { //&는 현재 선택자를 가져옴 (여기서는 해당 div)
        width: 80%;
        height: 80%;
        border: 3px solid black;

        & tr {
            background-color: orange;
        }
    }
`;

const KhSection = () => {
    
    return (
        <StyledSectionDiv>
            <table>
                <thead>
                    <tr className='abc'>
                    <th>번호</th>
                    <th>제목</th>
                    <th>내용</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>제목111</td>
                        <td>내용111</td>
                    </tr>
                </tbody>
            </table>
        </StyledSectionDiv>
    );
};

export default KhSection;