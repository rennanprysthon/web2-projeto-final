import {useCallback, useEffect, useState} from 'react'
import {get} from '../api/get';
import {post} from '../api/post';
import {drop} from '../api/delete';

import Form from '../components/Form';
import FormInput from '../components/FormInput';
import FormSubmit from '../components/FormSubmit';
import Select from '../components/Select';


import '../css/page/page.scss'
import ProdutoNovo from '../components/ProdutoNovo';

function Lote() {
  const [lotes, setLotes] = useState([])
  const [donatarios, setDonatarios] = useState([])
  const [fiscalizadores, setFiscalizadores] = useState([])
  const [produtos, setProdutos] = useState([])

  async function getLotes() {
    const data = await get('http://localhost:8080/lote')
    setLotes(data)
  }
  async function getOrgaoDonatario() {
    const data = await get('http://localhost:8080/orgao-donatario')
    setDonatarios(data)
  }
  async function getOrgaoFiscalizadores() {
    const data = await get('http://localhost:8080/orgao-fiscalizador')
    setFiscalizadores(data)
  }

  useEffect(() => {
    getLotes()
    getOrgaoDonatario()
    getOrgaoFiscalizadores()
  }, [])

  async function cadastrarLote(jsonValues) {
    let finalJson = {...jsonValues, produtos}


    await post('http://localhost:8080/lote', finalJson)
    getLotes()
    setProdutos([])
  }

  const deletar = useCallback(async (id) => {
    await drop('http://localhost:8080/lote/' + id)
    getLotes()
  })

  function adicionarProdutos(produto) {
    setProdutos(produtos => [...produtos, produto])
  }

  return (
    <div className="page">
      <h1 className='page__title'>Lote</h1>
      <section className="page__section">
        <div className="page__section__list">
          <table>
            <thead>
              <tr>
                <th>Id</th>
                <th>Data de entrega</th>
                <th>Orgao Donatario</th>
                <th>Orgao Fiscalizador</th>
                <th></th>

              </tr>
            </thead>
            <tbody>
              {
                lotes.map(lote => 
                  (
                    <tr>
                      <td>{lote.id}</td>
                      <td>{lote.dataEntrega}</td>
                      <td>{lote.orgaoDonatario.nome}</td>
                      <td>{lote.orgaoFiscalizador.nome}</td>
                      <td><button onClick={() => deletar(lote.id)}>Deletar</button></td>
                    </tr>
                  )
                )
              }
            </tbody>
          </table>
        </div>
        <div className="page__section__form--horizontal">
          <Form onSubmit={cadastrarLote}>
            <Select id="orgaoDonatarioId" values={donatarios} label="Selecione o donatario"/>
            <Select id="orgaoFiscalizadorId" values={fiscalizadores} label="Selecione o fiscalizador"/>

            <FormSubmit label="Enviar"/>
          </Form>
          <ProdutoNovo produtos={produtos} adicionarProdutos={adicionarProdutos}/>

        </div>
      </section>
    </div>
  )
}

export default Lote;