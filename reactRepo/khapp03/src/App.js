import './App.css';

function KhHeader(){
  return <h1>헤덬ㅋㅋㅋ킄ㅋ킄</h1>
}

function KhNavi(){    //컴포넌트 안에 다른 컴포넌트 쓰기, 컴포넌트에 어떤 데이터를 전달할 수도 있음
  return <div className="naviWrap">
    <KhNaviItem />
    <KhNaviItem />
    <KhNaviItem />
    <KhNaviItem />
  </div>
}

function KhNaviItem(){
  return <span>공지사항</span>;
}

function App() {
  return (        //리턴 뒤쪽에서 여러개의 컴포넌트 리턴 안됨, 하지만 자식이 많은건 상관 X
    <>
      <KhHeader />
      <KhNavi />
    </>
  );
}

export default App;
