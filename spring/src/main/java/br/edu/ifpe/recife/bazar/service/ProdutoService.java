package br.edu.ifpe.recife.bazar.service;

import br.edu.ifpe.recife.bazar.domains.Lote;
import br.edu.ifpe.recife.bazar.domains.Produto;
import br.edu.ifpe.recife.bazar.dtos.ProdutoNewDTO;
import br.edu.ifpe.recife.bazar.exceptions.EntityNotFound;
import br.edu.ifpe.recife.bazar.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    private final ProdutoRepository _produtoRepository;
    private final LoteService _loteService;

    public ProdutoService(ProdutoRepository produtoRepository, LoteService loteService) {
        this._produtoRepository = produtoRepository;
        this._loteService = loteService;
    }

    public Produto criarProduto(ProdutoNewDTO produtoNovo) {
        Lote lote = this._loteService.buscarLotePorId(produtoNovo.getLoteId());

        Produto produto = new Produto();
        produto.setCodigo(null);
        produto.setDescricao(produtoNovo.getDescricao());
        produto.setNome(produtoNovo.getNome());
        produto.setLote(lote);

        return this._produtoRepository.save(produto);
    }

    public Produto buscarProdutoPorId(Long id) {
        return this._produtoRepository.findById(id)
            .orElseThrow(() -> new EntityNotFound("Produto com id " + id + " nao foi encontrado"));
    }
}
