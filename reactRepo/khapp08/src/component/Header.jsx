import { useKhMemory } from '../context/KhContext';

const Header = () => {

    // const obj = useKhMemory();
    // const cnt = obj.cnt;
    // const setCnt = obj.setCnt;

    const {cnt, plus} = useKhMemory();

    return (
        <>
            <h1>
                Headerrrrrrrr
            </h1>
            <h3 onClick={plus}>{cnt}</h3>
        </>
    );
};

export default Header;