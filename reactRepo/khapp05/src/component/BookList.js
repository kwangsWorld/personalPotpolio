export default function BookList(){
    
    const book1 = {  //book이라는 객체 만든 것
        title: "상실의 시대",
        writer: "무라카미 하루키",
    }; 

    const book2 = {  //book이라는 객체 만든 것
        title: "해변의 카프카",
        writer: "이감퍼",
    }; 

    const book3 = {  //book이라는 객체 만든 것
        title: "1973년의 핀볼",
        writer: "곽때유니",
    }; 

    const bookList = [ book1, book2, book3];

    return (<>

    <div className="bookListWrap">
        <table>
            <thead>
                <tr>
                    <th>제목</th>
                    <th>저자</th>
                </tr>
            </thead>
            <tbody>
                { bookList.map( (x)=>{
                 return <tr>
                    <td>{x.title}</td>
                    <td>{x.writer}</td>
                 </tr>
                } ) }
            </tbody>
        </table>
    </div>
    </>);
}