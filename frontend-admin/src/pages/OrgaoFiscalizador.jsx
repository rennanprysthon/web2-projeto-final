import {useCallback, useEffect, useState} from 'react'
import {get} from '../api/get';
import {post} from '../api/post';
import {drop} from '../api/delete';

import Form from '../components/Form';
import FormInput from '../components/FormInput';
import FormSubmit from '../components/FormSubmit';

import '../css/page/page.scss'

function OrgaoFiscalizador() {
  const [orgaos, setOrgaos] = useState([])

  async function getOrgaos() {
    const data = await get('http://localhost:8080/orgao-fiscalizador')
    console.log(data)
    setOrgaos(data)
  }

  useEffect(() => {
    getOrgaos()
  }, [])

  async function cadastrarOrgaoNovo(jsonValues) {
    await post('http://localhost:8080/orgao-fiscalizador', jsonValues)
    getOrgaos()
  }

  return (
    <div className="page">
      <h1 className='page__title'>Orgãos fiscalizador</h1>
      <section className="page__section">
        <div className="page__section__list">
          <table>
            <thead>
              <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>Descricao</th>
              </tr>
            </thead>
            <tbody>
              {
                orgaos.map(orgao => 
                  (
                    <tr>
                      <td>{orgao.id}</td>
                      <td>{orgao.nome}</td>
                      <td>{orgao.descricao}</td>
                      <td>{orgao.descricao}</td>
                    </tr>
                  )
                )
              }
            </tbody>
          </table>
        </div>
        <div className="page__section__form">
          <h2>Criar orgao donatario</h2>
          <Form onSubmit={cadastrarOrgaoNovo}>
            <FormInput 
              id="nome"
              label="Nome"
            />
            <FormInput 
              id="descricao"
              label="Descricao"
            />

            <FormSubmit label="Enviar"/>
          </Form>
        </div>
      </section>
    </div>
  )
}

export default OrgaoFiscalizador;