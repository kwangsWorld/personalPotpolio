import { BrowserRouter, Routes, Route } from "react-router-dom";

import Header from "./Header";
import Navigator from "./Navigator"
import Footer from "./Footer";
import List from "./List";
import Add from "./Add";



export default function Wrap(){
    return (<>
            <BrowserRouter>
                <div>
                <Header />
                <Navigator />
                <Routes>
                    <Route path="/movie/list" element = {<List />}/>
                    <Route path="/movie/add" element = {<Add />}/>
                </Routes>
                <Footer />
                </div>
            </BrowserRouter>
    </>);
}