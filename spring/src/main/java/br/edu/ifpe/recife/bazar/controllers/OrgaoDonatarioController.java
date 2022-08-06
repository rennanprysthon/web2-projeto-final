package br.edu.ifpe.recife.bazar.controllers;

import br.edu.ifpe.recife.bazar.domains.Lote;
import br.edu.ifpe.recife.bazar.domains.OrgaoDonatario;
import br.edu.ifpe.recife.bazar.dtos.LoteDTO;
import br.edu.ifpe.recife.bazar.service.OrgaoDonatarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "orgao-donatario")
public class OrgaoDonatarioController {
    private final OrgaoDonatarioService _orgaoDonatarioService;

    public OrgaoDonatarioController(OrgaoDonatarioService orgaoDonatarioService) {
        this._orgaoDonatarioService = orgaoDonatarioService;
    }

    @GetMapping
    public ResponseEntity<List<OrgaoDonatario>> buscarTodos() {
        List<OrgaoDonatario> orgaoDonatarios = this._orgaoDonatarioService.buscarTodos();

        return ResponseEntity.ok(orgaoDonatarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrgaoDonatario> buscarPorId(@PathVariable("id") Long id) {
        OrgaoDonatario orgaoDonatario = this._orgaoDonatarioService.buscarPorId(id);

        return ResponseEntity.ok(orgaoDonatario);
    }

    @GetMapping("/{id}/lotes")
    public ResponseEntity<Set<LoteDTO>> buscarLotesPorOrgaoDonatario(@PathVariable("id") Long id) {
        Set<LoteDTO> lotes = this._orgaoDonatarioService.buscarLotesPorOrgao(id);

        return ResponseEntity.ok(lotes);
    }

    @PostMapping
    public ResponseEntity<?>  criarOrgaoDonatario(@RequestBody OrgaoDonatario orgaoDonatarioNovo) {
        OrgaoDonatario orgaoDonatarioCriado = this._orgaoDonatarioService.criarOrgaoDonatario(orgaoDonatarioNovo);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(orgaoDonatarioCriado.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
