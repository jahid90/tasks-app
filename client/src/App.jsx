import { Container, Row } from 'react-bootstrap';

import 'bootstrap/dist/css/bootstrap.min.css';

import './App.css';
import AddWorkspace from './components/AddWorkspace';
import Workspaces from './components/Workspaces';

function App() {
    return (
        <div className='app'>
            <header>
                <h1 className='app-header'>Tasks App</h1>
            </header>
            <Container fluid className='app-container'>
                <Row>
                    <AddWorkspace />
                </Row>
                <hr />
                <Row>
                    <Workspaces />
                </Row>
            </Container>
        </div>
    );
}

export default App;
