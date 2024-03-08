export default function Add(){

    return (<>
        <div className="add_title">Create Movie</div>
        <form className="form_crazy">
            <div>
                <input className="three" type="text" placeholder="input movie id"></input>
                <br/>
                <input className="three" type="text" placeholder="input movie title"></input>
                <br/>
                <input className="three" type="text" placeholder="input movie genre"></input>
                <br/>
                출시일: <input  className="date" type="date"></input>
                <br/>
                <input type="submit" value="Add Movie"></input>
                 <br/>
            </div>
        </form>
    
    </>)
}