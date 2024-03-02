import React from 'react';
import KhAside from './KhAside';
import KhSection from './KhSection';

    const x = {
        width: '100vw',
        height: '70vh',
        backgroundColor: 'lightgray',
        display: 'grid',
        gridTemplateRows: '1fr',
        gridTemplateColumns: '1fr 3fr 1fr',
    };


const KhMain = () => {
    return (
        <div style={x}>
            <KhAside />
            <KhSection />
            <KhAside />
        </div>
    );
};

export default KhMain;