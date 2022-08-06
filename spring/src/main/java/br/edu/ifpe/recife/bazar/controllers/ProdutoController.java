package br.edu.ifpe.recife.bazar.controllers;

import br.edu.ifpe.recife.bazar.service.ProdutoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "produto")
public class ProdutoController {
    private final ProdutoService _produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this._produtoService = produtoService;
    }
}
