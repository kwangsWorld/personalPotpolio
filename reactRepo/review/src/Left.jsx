import React  from 'react';
import { useMyContext } from './MyContext';

const Left = () => {

    const v = useMyContext();

    const minus = () => {
        v.setData(v.data-1);
    }

    return (
        <div onClick={minus}>
            leftttttt {v.data}
        </div>
    );
};

export default Left;