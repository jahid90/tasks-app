import React from 'react';

import Workspace from './Workspace';

const Workspaces = () => {
    return (
        <>
            <h2>List of workspaces:</h2>
            {Array(5)
                .fill(0)
                .map((_, i) => (
                    <Workspace key={i} id={i} />
                ))}
        </>
    );
};

export default Workspaces;
