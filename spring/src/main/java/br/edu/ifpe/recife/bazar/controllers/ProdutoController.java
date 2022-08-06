package br.edu.ifpe.recife.bazar.controllers;

import br.edu.ifpe.recife.bazar.domains.Produto;
import br.edu.ifpe.recife.bazar.dtos.ProdutoNewDTO;
import br.edu.ifpe.recife.bazar.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "produto")
public class ProdutoController {
    private final ProdutoService _produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this._produtoService = produtoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable("id") Long id) {
        Produto produto = this._produtoService.buscarProdutoPorId(id);

        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public ResponseEntity<?> criarProduto(@RequestBody ProdutoNewDTO produtoNovo) {
        Produto produto = this._produtoService.criarProduto(produtoNovo);

        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(produto.getCodigo())
            .toUri();

        return ResponseEntity.created(location).build();
    }
}
