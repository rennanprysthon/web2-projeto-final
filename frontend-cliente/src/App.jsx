import {useState} from 'react'

import Header from './components/Header.jsx'
import LoteList from './components/LoteList'

import './css/app.scss';

function App() {
  const [lotes, setLotes] = useState([])

  return (
    <main>
      <Header setLotes={setLotes}/>
      <LoteList lotes={lotes} />
    </main>
  )
}

export default App
