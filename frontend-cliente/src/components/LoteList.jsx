import '../css/components/LoteList.scss'

function LoteList({lotes}) {
  return (
    <ul className="lote-list">
      {
        lotes && lotes.map(lote => (
          <li key={lote.id} className="lote-list__item">
            <h2>
              Lote enviado na data {lote.dataEntrega}
            </h2>

            <ul className="product-list">
              {
                lote.produtos.map(produto => (
                  <li 
                    key={produto.id}
                    className="product-list__item"
                  >
                    {produto.nome}
                  </li>
                ))
              }  
            </ul> 
          </li>
        ))
      }
    </ul>
  )
}

export default LoteList