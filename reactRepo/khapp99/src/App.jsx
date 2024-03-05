import { BrowserRouter } from 'react-router-dom';
import './App.css';
import Layout from './component/Layout';

function App() {
    return (
      <BrowserRouter>
        <Layout color="white" age="20" size="1080" min="800"/>
      </BrowserRouter>
    );
}

export default App;
