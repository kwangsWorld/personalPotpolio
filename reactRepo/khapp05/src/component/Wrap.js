import { BrowserRouter, Routes, Route } from "react-router-dom";  //export default로 내보낸게 아닌건 이런 형식으로 import해야함

import Header from "./Header";
import Navigator from "./Navigator";
import Footer from "./Footer";
import BookList from "./BookList";
import BookInsert from "./BookInsert";

export default function Wrap() {
    return (<>
            <BrowserRouter>
                <div className="kh">
                    <Header />
                    <Navigator />
                    
                    <Routes>
                        <Route path="/book/list" element = {<BookList />} />
                        <Route path="/book/insert" element={<BookInsert />} />
                    </Routes>

                    <Footer />
                </div>
            </BrowserRouter>
    </>);
}