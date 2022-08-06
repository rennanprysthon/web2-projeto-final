import {useEffect, useState} from 'react'
import Select from "./Select";
import {get} from '../api/get.js'
import '../css/components/Header.scss';

function Header({setLotes}) {
  const [donatarios, setDonatarios] = useState([])
  const [donatarioSelected, setDonatarioSelected] = useState(null);

  async function fetchLotesByOrganization(id) {
    if (!id) return;

    const data = await get(`http://localhost:8080/orgao-donatario/${id}/lotes`)
    setLotes(data)
  }

  async function fetchData() {
    const data = await get('http://localhost:8080/orgao-donatario')
    setDonatarios(data);
  }

  useEffect(() => {
    fetchData();
  }, [])

  useEffect(() => {
    fetchLotesByOrganization(donatarioSelected)
  }, [donatarioSelected])

  return (
    <header className="header">
      <label className="header__label" htmlFor="donatario-select">Escolha o orgão donatario</label>
      <Select id="donatario-select" values={donatarios} setDonatarioSelected={setDonatarioSelected}/>
    </header>
  )
}


export default Header;