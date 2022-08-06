package br.edu.ifpe.recife.bazar.controllers;

import br.edu.ifpe.recife.bazar.domains.OrgaoFiscalizador;
import br.edu.ifpe.recife.bazar.service.OrgaoFiscalizadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/orgao-fiscalizador")
public class OrgaoFiscalizadorController {
    private final OrgaoFiscalizadorService _orgaoFiscalizadorService;

    public OrgaoFiscalizadorController(OrgaoFiscalizadorService orgaoFiscalizadorService) {
        this._orgaoFiscalizadorService = orgaoFiscalizadorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrgaoFiscalizador> buscarPorId(@PathVariable("id") Long id) {
        OrgaoFiscalizador orgaoDonatario = this._orgaoFiscalizadorService.buscarPorId(id);

        return ResponseEntity.ok(orgaoDonatario);
    }

    @PostMapping
    public ResponseEntity<?>  criarOrgaoFiscalizador(@RequestBody OrgaoFiscalizador orgaoDonatarioNovo) {
        OrgaoFiscalizador orgaoDonatarioCriado = this._orgaoFiscalizadorService.criarOrgaoFiscalizador(orgaoDonatarioNovo);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(orgaoDonatarioCriado.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
