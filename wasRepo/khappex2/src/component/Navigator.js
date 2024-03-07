import { Link } from "react-router-dom";


export default function Navigator(){

    return ( <>
        <div className="select">
            <Link to="/movie/list">List</Link>
            <Link to="/movie/add">Add new Movie</Link>
        </div>
    </>);
}
