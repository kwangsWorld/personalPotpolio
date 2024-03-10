// import React from 'react';
// import {BrowserRouter, Route, Routes} from 'react-router-dom';
// import BoardDetail from './BoardDetail';

// const Chap02Main = () => {
//     return (
//         <div>
//             <BrowserRouter>
//                 <Routes>
//                     <Route path="board/*">
//                         <Route path="write" element={<h1>게시글 작성</h1>} />
//                         <Route path="list" element={<h1>게시글 목록</h1>} />
//                         <Route path="detail/:no" element={<BoardDetail />} />
//                     </Route>
//                     <Route path="gallery/*" element={<h1>갤러리 메인ㅋㅋ</h1>}/>
//                     <Route path="notice/*" element={<h1>공지사항 메인ㅋㅋ</h1>}/>
//                 </Routes>
//             </BrowserRouter>
//         </div>
//     );
// };

// export default Chap02Main;

import React, { useState } from 'react';

const ToggleArrowWithContent = () => {
  const [isContentVisible, setIsContentVisible] = useState(false);

  const toggleContent = () => {
    setIsContentVisible((prev) => !prev);
  };

  return (
    <div>
      <div onClick={toggleContent}>
        <span>토글{isContentVisible ? '▲' : '▼'} </span>
      </div>
      {isContentVisible && (
        <div>
          {/* 토글되는 내용 */}
          <p>내용이 여기에 나타납니다.</p>
          <p>다른 내용도 추가할 수 있습니다.</p>
        </div>
      )}
    </div>
  );
};

export default ToggleArrowWithContent;
