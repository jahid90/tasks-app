import 'bootstrap/dist/css/bootstrap.min.css';

import './App.css';
import Workspaces from './components/Workspaces';

function App() {
    return (
        <div className='app'>
            <header className='app-header'>Tasks App</header>
            <Workspaces />
        </div>
    );
}

export default App;
