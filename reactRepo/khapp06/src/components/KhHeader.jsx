import React from "react";
import LoginArea from "./LoginArea";

const KhHeader = () => {

    const x = {
        width : '100vw',
        height: '20vh',
        backgroundColor : 'gray' ,
        display: 'grid' ,
        gridTemplateRows: '1fr',
        gridTemplateColumns: '1fr 3fr 1fr'
    }


    return (
        <div style={x}>
            <div>빈칸</div>
            <div>로고</div>
            <LoginArea />
        </div>
    );
};

export default KhHeader;