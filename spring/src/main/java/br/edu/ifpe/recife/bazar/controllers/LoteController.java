package br.edu.ifpe.recife.bazar.controllers;

import br.edu.ifpe.recife.bazar.domains.Lote;
import br.edu.ifpe.recife.bazar.domains.Produto;
import br.edu.ifpe.recife.bazar.dtos.LoteNewDTO;
import br.edu.ifpe.recife.bazar.service.LoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "lote")
public class LoteController {
    private final LoteService _loteService;

    public LoteController(LoteService loteService) {
        this._loteService = loteService;
    }

    @GetMapping()
    public ResponseEntity<List<Lote>> buscarTodos() {
        List<Lote> lotes = this._loteService.buscarTodos();

        return ResponseEntity.ok(lotes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lote> buscarLotePorId(@PathVariable("id") Long id) {
        Lote lote = this._loteService.buscarLotePorId(id);

        return ResponseEntity.ok(lote);
    }

    @GetMapping("/{id}/produtos")
    public ResponseEntity<Set<Produto>> buscarProdutosPorLote(@PathVariable("id") Long id) {
        Set<Produto> produtos = this._loteService.buscarProdutosPorLote(id);

        return ResponseEntity.ok(produtos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerLote(@PathVariable("id") Long id) {
        this._loteService.deletarLote(id);

        return ResponseEntity.accepted().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarLote(@PathVariable("id") Long id, @RequestBody Lote lote) {
        this._loteService.editarLote(lote, id);

        return ResponseEntity.accepted().build();
    }

    @PostMapping
    public ResponseEntity<?> criarLote(@RequestBody LoteNewDTO loteNewDTO) {
        Lote loteCriado =this._loteService.criarLote(loteNewDTO);

        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(loteCriado.getId())
            .toUri();

        return ResponseEntity.created(location).build();
    }
}
