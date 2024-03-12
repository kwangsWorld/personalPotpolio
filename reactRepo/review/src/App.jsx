import './App.css';
import Left from './Left';
import Right from './Right';
import { MyContextProvider } from './MyContext';

function App() {


  return <>
    <MyContextProvider>
      <Left />
      <Right />
    </MyContextProvider>
  </>;
}


export default App;
