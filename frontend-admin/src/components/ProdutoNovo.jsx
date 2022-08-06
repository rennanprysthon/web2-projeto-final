import {useRef, useState} from 'react'

function ProdutoNovo({produtos, adicionarProdutos }) {
  const produtoRef = useRef(null)
  const [produto, setProduto] = useState({
    nome: '',
    descricao: ''
  })
  function onSubmit (event) {
    event.preventDefault()
    adicionarProdutos(produto)
    produtoRef.current.reset()
  }
  return (
    <div>
      <h3>Adicionar produtos</h3>
      <ul className='produto-novo-list'>
        {produtos.map((produto, index) => (
          <li key={index}>
            <span>
              <strong>Nome</strong>
              <div>{produto.nome}</div>
            </span>
            <span>
              <strong>Descricao</strong>
              <div>{produto.descricao}</div>
            </span>
          </li>
        ))}
      </ul>
      <form ref={produtoRef} onSubmit={onSubmit} className="produto-form">
        <label htmlFor="">Nome</label>
        <input type="text" id="produtoNome" required onChange={({target}) => setProduto(produto => ({...produto, ...{nome: target.value}})) } />
        <label htmlFor="">Descricao</label>
        <input type="text" id="produtoDescricao" required onChange={({target}) => setProduto(produto => ({...produto, ...{descricao: target.value}})) } />
        <input type="submit" value="Adicionar Produto" />
      </form>
    </div>
  )
}

export default ProdutoNovo