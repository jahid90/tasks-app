import React from 'react';
import { Col } from 'react-bootstrap';

const Workspace = ({ id }) => {
    return (
        <Col>
            <div>This is workspace {id}</div>
        </Col>
    );
};

export default Workspace;
