import { useState } from 'react';
import './App.css';
import { useEffect } from 'react';
import { useRef } from 'react';

function App() {

  const x = useRef();

  useEffect( () => {
    const t = setInterval(() => {
      console.log("안녕하세요");
    }, 3000);
    return ()=>{
      clearInterval(t);
    };
  } );

  const [data , setData] = useState(1);

  function f01(){
    setData(data+1);
  }
  
  function f02(){
    console.log(x);
  }

  return (
    <>
      <h1 ref={x}>안녕</h1>
      <button onClick={f01}>x 출력하기</button>
      <hr />
      <button onClick={f01}>플러스</button>
      <h3>{data}</h3>
    </>
  );
}

export default App;
