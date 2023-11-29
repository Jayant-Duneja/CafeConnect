import { Routes, Route } from 'react-router-dom';
import './App.css';
import Header from './components/Header';
import Student from './pages/Student';
import CafePage from './pages/CafePage';

function App() {
  return (
    <div className="App">
      <Header />
      <Routes>
        <Route path="/student" element={<Student />} />
        <Route path="/cafe/:id" element={<CafePage />} />
      </Routes>
    </div>
  );
}

export default App;
