import React  from 'react';
import { useMyContext } from './MyContext';

const Right = () => {

    const v = useMyContext();

    const plus = () => {
        v.setData(v.data+1);
    }

    return (
        <div onClick={plus}>
            righttttt {v.data}
        </div>
    );
};

export default Right;