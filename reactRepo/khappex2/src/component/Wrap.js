import { BrowserRouter, Routes, Route  } from "react-router-dom";
import Navigator from "./Navigator";
import List from "./List";
import Add from "./Add";



export default function Wrap(){
    return ( <>
            <BrowserRouter>
                <div>
                <Navigator />
                <Routes>
                    <Route path="/movie/list" element = {<List />} />
                    <Route path="/movie/add" element = {<Add />} />
                </Routes>
                </div>
            
            
            
            </BrowserRouter>
    
    
    
    </>);
}