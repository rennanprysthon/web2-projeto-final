package br.edu.ifpe.recife.bazar.controllers;

import br.edu.ifpe.recife.bazar.service.OrgaoFiscalizadorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orgao-fiscalizador")
public class OrgaoFiscalizadorController {
    private final OrgaoFiscalizadorService _orgaoFiscalizadorService;

    public OrgaoFiscalizadorController(OrgaoFiscalizadorService orgaoFiscalizadorService) {
        this._orgaoFiscalizadorService = orgaoFiscalizadorService;
    }
}
