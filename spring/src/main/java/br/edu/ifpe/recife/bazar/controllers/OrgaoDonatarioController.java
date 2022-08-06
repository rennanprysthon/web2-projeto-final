package br.edu.ifpe.recife.bazar.controllers;

import br.edu.ifpe.recife.bazar.domains.OrgaoDonatario;
import br.edu.ifpe.recife.bazar.service.OrgaoDonatarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "orgao-donatario")
public class OrgaoDonatarioController {
    private final OrgaoDonatarioService _orgaoDonatarioService;

    public OrgaoDonatarioController(OrgaoDonatarioService orgaoDonatarioService) {
        this._orgaoDonatarioService = orgaoDonatarioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrgaoDonatario> buscarPorId(@PathVariable("id") Long id) {
        OrgaoDonatario orgaoDonatario = this._orgaoDonatarioService.buscarPorId(id);

        return ResponseEntity.ok(orgaoDonatario);
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
