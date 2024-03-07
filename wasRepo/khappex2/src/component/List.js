
export default function List(){

    const movie1 = {
        id: "1",
        title: "Movie1",
        genre: "Drama",
        releaseDate: "2022-01-01",
        action: "Delete"
    }

    const movie2 = {
        id: "1",
        title: "Movie2",
        genre: "Action",
        releaseDate: "2022-02-01",
        action: "Delete"
    }

    const movie3 = {
        id: "3",
        title: "Movie3",
        genre: "Comedy",
        releaseDate: "2022-03-01",
        action: "Delete"
    }

    const movieList = [movie1, movie2, movie3];

    return (<>
        <div className="list_title">Movies</div>
        <div>
            <table className="list_table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Genre</th>
                        <th>Release Date</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    { movieList.map( (x)=>{
                        return <tr>
                            <td>{x.id}</td>
                            <td>{x.title}</td>
                            <td>{x.genre}</td>
                            <td>{x.releaseDate}</td>
                            <td><button>{x.action}</button></td>
                        </tr>
                    })}
                </tbody>
            </table>
        </div>
    </>);
}