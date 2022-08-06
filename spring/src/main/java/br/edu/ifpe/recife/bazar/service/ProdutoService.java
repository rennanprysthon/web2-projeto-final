package br.edu.ifpe.recife.bazar.service;

import br.edu.ifpe.recife.bazar.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    private final ProdutoRepository _produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this._produtoRepository = produtoRepository;
    }
}
