import { Outlet } from 'react-router-dom';
import Header from './components/Header';
import Navigation from './components/Navigation';
import './css/app.scss';

function App() {
  return (
    <>
      <Header />
      <Outlet />
    </>
  )
}

export default App
