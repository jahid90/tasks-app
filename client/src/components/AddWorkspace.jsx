import React, { useState } from 'react';
import { Button, Col, Form } from 'react-bootstrap';

const AddWorkspace = () => {
    const [name, setName] = useState('');
    const [description, setDescription] = useState('');

    const handleNameChange = (e) => {
        setName(e.target.value);
    };

    const handleDescriptionChange = (e) => {
        setDescription(e.target.value);
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        console.log(`submitted: name=${name} description=${description}`);

        setName('');
        setDescription('');
    };

    return (
        <Col>
            <h3>Create a workspace</h3>
            <Form onSubmit={handleSubmit}>
                <Form.Group className='mb-3' controlId='name'>
                    <Form.Label>Workspace Name</Form.Label>
                    <Form.Control
                        type='text'
                        placeholder='Enter workspace name'
                        value={name}
                        onChange={handleNameChange}
                    />
                </Form.Group>

                <Form.Group className='mb-3' controlId='description'>
                    <Form.Label>Description</Form.Label>
                    <Form.Control
                        type='text'
                        placeholder='Enter a description'
                        value={description}
                        onChange={handleDescriptionChange}
                    />
                </Form.Group>

                <Button variant='primary' type='submit'>
                    Create
                </Button>
            </Form>
        </Col>
    );
};

export default AddWorkspace;
