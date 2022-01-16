import React from 'react';
import { Button, Col, Form } from 'react-bootstrap';

function AddWorkspace() {
    return (
        <Col>
            <h3>Create a workspace</h3>
            <Form>
                <Form.Group className='mb-3' controlId='name'>
                    <Form.Label>Workspace Name</Form.Label>
                    <Form.Control type='text' placeholder='Enter workspace name' />
                </Form.Group>

                <Form.Group className='mb-3' controlId='description'>
                    <Form.Label>Description</Form.Label>
                    <Form.Control type='text' placeholder='Enter a description' />
                </Form.Group>

                <Button variant='primary' type='submit'>
                    Create
                </Button>
            </Form>
        </Col>
    );
}

export default AddWorkspace;
