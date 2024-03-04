import './App.css';
import Header from './component/Header';
import Main from './component/Main';
import { KhMemoryProvider } from './context/KhContext';

function App() {

const result = 1+2+3+4+5;
const nick = "홍길동";

const obj = {
  x:result,
  y:"와이"
};

  return (
    <>
      <KhMemoryProvider>
        <Header/>
        <Main/>
      </KhMemoryProvider>
    </>
  );
}

export default App;
