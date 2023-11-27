import { Routes, Route } from 'react-router-dom';
import './App.css';
import Header from './components/Header';
import Student from './pages/Student';

function App() {
  return (
    <div className="App">
      <Header />
      <Routes>
        <Route path="/student" element={<Student />} />
      </Routes>
    </div>
  );
}

export default App;
